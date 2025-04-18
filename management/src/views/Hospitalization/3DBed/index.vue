<template>
  <div ref="container" class="three-container">
    <!-- 控制面板：切换视图模式和绘制模式 -->
    <div class="control-panel">
      <!-- 新增楼层选择下拉框 -->
      <select v-model="selectedFloor" @change="changeFloor">
        <option v-for="floor in floors" :key="floor.value" :value="floor.value">
          {{ floor.name }}
        </option>
      </select>
      <button :style="{ backgroundColor:mode === 'view'?'black':'gray', color: 'white' }" @click="setMode('view')">视图模式</button>
      <button :style="{ backgroundColor:mode === 'draw'?'black':'gray', color: 'white' }" @click="setMode('draw')">绘制模式</button>
      <button :style="{ backgroundColor:mode === 'select' ? 'black' : 'gray', color: 'white' }" @click="setMode('select')">选择模式</button>
    </div>
    <div class="control-panel-right">
      <button @click="controls.reset();">恢复视图</button>
      <button 
      @click="SetViewRotation"
       :style="{ backgroundColor:ViewRotation?'gray':'black', color: 'white' }"
      >
      {{ViewRotation?"锁定旋转":"解除旋转"}}
      </button>
    </div>
    <div class="info">
      <span style="color: gray;">
        按ctrl键可以快速切换模式
      </span>
      <span>;</span>
      <span style="color: gray;" v-show="ViewRotation">
        按住 Shift + 鼠标左键 进行旋转
      </span>
    </div>
    <div v-if="mode === 'select' && selectedCube" class="property-panel">
      <h4>几何属性</h4>
      <div>
        <label>颜色：</label>
        <input type="color" v-model="selectedCubeProperties.color" @change="updateCubeProperties">
      </div>
      <div>
        <label>透明度：</label>
        <input type="range" min="0" max="1" step="0.01" v-model.number="selectedCubeProperties.opacity" @change="updateCubeProperties">
      </div>
      <div>
        <label>宽(x)：</label> {{selectedCubeProperties.width}}
      </div>
      <div>
        <label>高(y)：</label>{{selectedCubeProperties.height}}
      </div>
      <div>
        <label>深(z)：</label>{{selectedCubeProperties.depth}}
      </div>
      <h4>病床信息</h4>
      <div v-if="selectedCubeProperties.bedInfo !== null">
        <div v-for="(value, key) in selectedCubeProperties.bedInfo" :key="key">
          <span>{{key}}</span>:<span>{{value}}</span>
        </div>
        <div>
          <button @click="props.update(selectedCubeProperties.bedInfo)">修改信息</button>
        </div>
      </div>
      <div>
        病房号:<input type="text"  v-model="RoomNumber" placeholder="请输入病房号" /><br>
        床位号:<input type="number"  v-model="BedNumber" placeholder="请输入床位号" />
        <div>
          <button @click="bind(RoomNumber,BedNumber)">绑定床位</button>
        </div>
      </div>
      <button @click="_delete">删除模型</button>
    </div>
    
    <!-- 加载中遮罩层 -->
    <div v-if="loading" class="loading-overlay">
      <span>加载中...</span>
    </div>
  </div>
</template>

<script setup>
import { ref,reactive,onMounted,onBeforeUnmount,defineProps,toRaw } from 'vue'
import * as THREE from 'three'
import { OrbitControls } from 'three/examples/jsm/controls/OrbitControls.js'
import { GLTFLoader } from 'three/examples/jsm/loaders/GLTFLoader.js'
import { ElMessage } from 'element-plus';
import BedApi from "@/api/BE/api/HospitalbedsApi.js"
import ModelApi from "@/api/model3d.js"
import dayjs from "dayjs";

const props = defineProps({
  update: {
    type: Function,
    required: true
  }
})

// 引用和状态
const container = ref(null)
const loading = ref(true)
const selectedCube = ref(null);
const RoomNumber = ref(null);
const BedNumber = ref(null);



const bind = async (RoomNumber,BedNumber)=>{
    try{
      const res = await ModelApi.bindBed(selectedCube.value.userData.id,RoomNumber,BedNumber);
      ElMessage.success("绑定成功")
    }catch(err){
      console.error(err)
    }
}

// 用于存储选中 cube 的属性，初始值可根据实际 cube 默认创建时的属性来设置
const selectedCubeProperties = reactive({
  color: '#00ff00',
  opacity: 0.5,
  width: 1,
  height: 1,
  depth: 1,
  bedInfo:null
});

// 模式：'view' 表示视图旋转，'draw' 用于绘制
const mode = ref('view')
const ViewRotation = ref(true)
// Three.js 全局变量（避免 Vue 响应式系统）
let scene, camera, renderer, controls, raycaster, helperPlane, model
let box,size,cubeList=[],rect,sphere,floor_number
// 监听键盘松开事件
window.addEventListener('keyup', onKeyUp, false);

const SetViewRotation = ()=>{
  controls.enableRotate = !controls.enableRotate;
  ViewRotation.value = controls.enableRotate;
}

function onKeyUp(event) {
    // 检查是否松开了 Ctrl 键
    if (event.key === 'Control') {
        if(mode.value === 'view') setMode('draw')
        else if(mode.value === 'draw')setMode('view')
    }else if(event.key === 'r'){
      SetViewRotation()
    }
}

const updateCubeProperties = () => {
  if (!selectedCube.value) return;
  // 更新颜色和透明度
  selectedCube.value.material.color.set(selectedCubeProperties.color);
  selectedCube.value.material.opacity = parseFloat(selectedCubeProperties.opacity);
}
function disposeMesh(mesh, renderer) {
  // 1. 递归释放几何体 & 材质 & 纹理
  mesh.traverse((child) => {
    if (child.isMesh) {
      child.geometry?.dispose();
      const mat = child.material;
      if (Array.isArray(mat)) {
        mat.forEach(m => {
          m.map?.dispose();
          m.dispose();
        });
      } else if (mat) {
        mat.map?.dispose();
        mat.dispose();
      }
    }
  });

  // 2. 从父节点移除
  mesh.parent?.remove(mesh);

  // 3. 清空渲染列表缓存
  renderer?.renderLists.dispose();

  // 4. （可选）清理引用
  const idx = cubeList.indexOf(mesh);
  if (idx !== -1) cubeList.splice(idx, 1);
}
const _delete = async ()=>{
  try{
      const res = await ModelApi._delete(selectedCube.value.userData.id);
      disposeMesh(toRaw(selectedCube.value))
      ElMessage.success("删除成功")
    }catch(err){
      console.error(err)
    }
}
// 添加楼层配置
const floors = [
  { name: '一层', value: 'storey_1min',floor_number:1 },
  { name: '二层', value: 'storey_2min',floor_number:2 },
  { name: '三层', value: 'storey_3min',floor_number:3 },
  { name: '四层', value: 'storey_4min',floor_number:4 },
  { name: '五层', value: 'storey_5min',floor_number:5 },
]
const selectedFloor = ref('storey_3min')
floor_number = 3
// 修改模型加载部分
const loadModel = async (modelName) => {
  loading.value = true
  try {
    // 移除旧模型
    if (model) {
      scene.remove(model)
      // 释放模型资源
      model.traverse(child => {
        if (child.isMesh) {
          child.geometry.dispose()
          child.material.dispose()
        }
      })
      model = null
    }

    // if(cubeList){
    //   console.log("cubeList:",cubeList)
    //   for(let item of cubeList){
    //     disposeMesh(item)
    //   }
    // }

    // 加载新模型
    const loader = new GLTFLoader()
    const gltf = await loader.loadAsync(
      require(`@/assets/3dModel/${modelName}.glb`)
    )
    
    model = gltf.scene
    model.rotation.x = -Math.PI / 2
    model.traverse(child => {
      if (child.isMesh) {
        child.material.transparent = true
        child.material.opacity = 0.7
      }
    })
    scene.add(model)

    // 更新场景设置
    box = new THREE.Box3().setFromObject(model)
    fitModelToCamera(box)
    size = new THREE.Vector3()
    box.getSize(size)
    helperPlane.geometry = new THREE.PlaneGeometry(size.x, size.y)
    const center = new THREE.Vector3()
    box.getCenter(center)
    helperPlane.position.set(center.x, center.y, center.z)
    controls.target.copy(center)
    // 向上旋转 90 度
    const angle = THREE.MathUtils.degToRad(90); // 转换为弧度
    controls._rotateUp(angle);
    controls.update()
    controls.saveState();
  } catch (error) {
    console.error('模型加载失败:', error)
  } finally {
    loading.value = false
  }
}

// 添加楼层切换处理
const changeFloor = () => {
  floor_number = floors.find(item => item.value === selectedFloor.value).floor_number;
  // 清除已选中的cube
  if (selectedCube.value) {
    selectedCube.value.remove(selectedCube.value.userData.outline)
    selectedCube.value = null
  }
  loadModel(selectedFloor.value)
}

// 绘制矩形相关变量
let clickCount = 0
let points = []
let tempLine = null
let previewLine = null

// 初始化 Three.js 场景、相机、渲染器、控件以及模型加载
async function init() {
  // 创建场景并设置背景色
  scene = new THREE.Scene()
  scene.background = new THREE.Color(0xeeeeee)

  // 获取容器尺寸，初始化正交相机
  const width = container.value.clientWidth
  const height = container.value.clientHeight
  const aspect = width / height
  const frustumSize = 100
  camera = new THREE.OrthographicCamera(
    (-frustumSize * aspect) / 2,
    (frustumSize * aspect) / 2,
    frustumSize / 2,
    -frustumSize / 2,
    -1000,
    1000
  )
  // 将相机放置在正上方
  camera.position.set(0, 100, 0)
  camera.up.set(0, 0, -1)
  camera.lookAt(new THREE.Vector3(0, 0, 0))

  // 创建渲染器并挂载到 DOM
  renderer = new THREE.WebGLRenderer({ antialias: true })
  renderer.setSize(width, height)
  container.value.appendChild(renderer.domElement)

  // 添加环境光和方向光
  const ambientLight = new THREE.AmbientLight(0xffffff, 0.8)
  scene.add(ambientLight)
  const directionalLight = new THREE.DirectionalLight(0xffffff, 0.6)
  directionalLight.position.set(100, 100, 100)
  scene.add(directionalLight)

  // 初始化 OrbitControls（仅操作相机，实现视图旋转）
  controls = new OrbitControls(camera, renderer.domElement)
  controls.mouseButtons = {
    LEFT: THREE.MOUSE.PAN,       // 左键平移
    MIDDLE: THREE.MOUSE.ROTATE,  // 中键旋转
    RIGHT: THREE.MOUSE.DOLLY     // 右键缩放
  };
  controls.enableRotate = false
  ViewRotation.value = false
  controls.minPolarAngle = 0
  controls.maxPolarAngle = Math.PI / 2
  // 控件目标将在模型加载后调整为模型中心
  controls.target.set(0, 0, 0)

  // 初始化 Raycaster，用于鼠标拾取辅助平面上的位置
  raycaster = new THREE.Raycaster()

  // 创建辅助半透明平面（大小后续根据模型更新）
  const planeGeo = new THREE.PlaneGeometry(200, 200)
  const planeMat = new THREE.MeshBasicMaterial({
    color: 0xffc0cb,
    side: THREE.DoubleSide,
    transparent: true,
    opacity: 0.5
  })
  helperPlane = new THREE.Mesh(planeGeo, planeMat)
  scene.add(helperPlane)

  const res = await ModelApi.getByFloor(3)
  if(res.code === 200){
    const list = res.data
    for(let item of list){
      // 创建一个 ObjectLoader 实例
      const loader = new THREE.ObjectLoader();
      // 将 JSON 字符串解析回 Group 对象
      const parsedGroup = loader.parse(JSON.parse(item.model_data));
      parsedGroup.traverse(node => {
        node.matrixAutoUpdate = false; 
        node.updateMatrix(); 
      });
      parsedGroup.children[2].userData.bed_id = item.bed_id
      parsedGroup.children[2].userData.id = item.id
      cubeList.push(parsedGroup)
      // cubeList.push(parsedGroup)
      scene.add(parsedGroup)
      scene.updateMatrixWorld(true);
    }
  }

  // 替换原来的加载代码
  loadModel(selectedFloor.value)  // 初始加载默认楼层
  window.addEventListener('resize', onWindowResize)
  renderer.domElement.addEventListener('click', onClick)
  renderer.domElement.addEventListener('mousemove', onMouseMove)

  animate()
}

// 根据模型包围盒调整相机参数与位置
function fitModelToCamera(box) {
  const center = new THREE.Vector3(), size = new THREE.Vector3()
  box.getCenter(center)
  box.getSize(size)
  // 将相机定位到模型正上方
  camera.position.set(center.x, center.y + size.y, center.z)
  camera.lookAt(center)
  const maxDim = Math.max(size.x, size.z)
  const aspect = container.value.clientWidth / container.value.clientHeight
  camera.left = (-maxDim * aspect) / 2
  camera.right = (maxDim * aspect) / 2
  camera.top = maxDim / 2
  camera.bottom = -maxDim / 2
  camera.updateProjectionMatrix()
}

// 窗口尺寸改变时更新渲染器与相机参数
function onWindowResize() {
  const width = container.value.clientWidth
  const height = container.value.clientHeight
  renderer.setSize(width, height)
  const aspect = width / height
  const frustumSize = 100
  camera.left = (-frustumSize * aspect) / 2
  camera.right = (frustumSize * aspect) / 2
  camera.top = frustumSize / 2
  camera.bottom = -frustumSize / 2
  camera.updateProjectionMatrix()
}

// 动画循环
function animate() {
  requestAnimationFrame(animate)
  // 视图模式下启用 OrbitControls，使相机旋转而不影响模型姿态
  controls.enabled = mode.value === 'view'
  renderer.render(scene, camera)
}

// 将鼠标事件转换为辅助平面上的交点
function getMouseIntersection(event) {
  const rect = renderer.domElement.getBoundingClientRect()
  const mouse = new THREE.Vector2(
    ((event.clientX - rect.left) / rect.width) * 2 - 1,
    -((event.clientY - rect.top) / rect.height) * 2 + 1
  )
  raycaster.setFromCamera(mouse, camera)
  const intersects = raycaster.intersectObject(helperPlane)
  return intersects.length > 0 ? intersects[0].point : null
}

let tag = 0
// 鼠标点击事件：用于在“绘制模式”下绘制矩形轮廓
async function onClick(event) {
  if (mode.value === 'select') {
    const rect = renderer.domElement.getBoundingClientRect();
    const mouse = new THREE.Vector2(
      ((event.clientX - rect.left) / rect.width) * 2 - 1,
      -((event.clientY - rect.top) / rect.height) * 2 + 1
    );
    raycaster.setFromCamera(mouse, camera);
    // 寻找所有包含 selectable 标记的对象（递归搜寻）
    const intersects = raycaster.intersectObjects(scene.children, true);
    let foundCube = null;
    for (let i = 0; i < intersects.length; i++) {
      if (intersects[i].object.userData.selectable) {
        foundCube = intersects[i].object;
        break;
      }
    }
    if (foundCube) {
      // 移除先前选中 cube 的蓝色轮廓效果
      if (selectedCube.value && selectedCube.value.userData.outline) {
        selectedCube.value.remove(selectedCube.value.userData.outline);
        delete selectedCube.value.userData.outline;
      }
      selectedCube.value = foundCube;

      // 添加蓝色蓝光效果：新建一个略大于原始几何体的子网格
      const glowMaterial = new THREE.MeshBasicMaterial({
        color: 0x0000ff,
        side: THREE.BackSide,
        transparent: true,
        opacity: 0.5,
      });
      const glowMesh = new THREE.Mesh(foundCube.geometry.clone(), glowMaterial);
      glowMesh.scale.multiplyScalar(1.05);
      foundCube.add(glowMesh);
      foundCube.userData.outline = glowMesh;

      // 同步 selectedCubeProperties（颜色转为16进制字符串）
      selectedCubeProperties.color = '#' + foundCube.material.color.getHexString();
      selectedCubeProperties.opacity = foundCube.material.opacity;
      // 根据包围盒获取尺寸：宽(x)、高(y)、深(z)
      const bbox = new THREE.Box3().setFromObject(foundCube);
      const sizeVec = new THREE.Vector3();
      bbox.getSize(sizeVec);
      selectedCubeProperties.width = sizeVec.x;
      selectedCubeProperties.height = sizeVec.y;
      selectedCubeProperties.depth = sizeVec.z;
      if(foundCube.userData.bed_id!==null){
        const res = await BedApi.searchByField(foundCube.userData.bed_id);
        res.data.list[0].updated_at = dayjs(res.data.list[0].updated_at).format("YYYY-MM-DD")
        res.data.list[0].lastUpdated = dayjs(res.data.list[0].lastUpdated).format("YYYY-MM-DD")
        selectedCubeProperties.bedInfo = res.data.list[0]
      }else  selectedCubeProperties.bedInfo = null
    }
    return;
  }
  if (mode.value !== 'draw') return
  const point = getMouseIntersection(event)
  if (!point) return
  clickCount++
  if (clickCount === 1) {
    points[0] = point.clone()
    sphere = new THREE.Mesh(
      new THREE.SphereGeometry(0.1, 5, 5),
      new THREE.MeshBasicMaterial({ color: 0xff0000 })
    )
    sphere.position.copy(point)
    scene.add(sphere)
    tempLine = new THREE.Line(
      new THREE.BufferGeometry().setFromPoints([point, point]),
      new THREE.LineBasicMaterial({ color: 0x0000ff })
    )
    scene.add(tempLine)
  } else if (clickCount === 2) {
    points[1] = point.clone()
    if (tempLine) {
      scene.remove(tempLine)
      tempLine = null
    }
    previewLine = new THREE.Line(
      new THREE.BufferGeometry().setFromPoints([points[0], points[1], points[1], points[0],points[0]]),
      new THREE.LineBasicMaterial({ color: 0x00ff00 })
    )
    scene.add(previewLine)
  } else if (clickCount === 3) {
    points[2] = point.clone()
    const dir = new THREE.Vector3().subVectors(points[1], points[0]).normalize()
    const v = new THREE.Vector3().subVectors(points[2], points[0])
    const projLength = v.dot(dir)
    const projVec = dir.clone().multiplyScalar(projLength)
    const offset = new THREE.Vector3().subVectors(v, projVec)
    const A = points[0]
    const B = points[1]
    const C = new THREE.Vector3().addVectors(B, offset)
    const D = new THREE.Vector3().addVectors(A, offset)
    if (previewLine) {
      scene.remove(previewLine)
      previewLine = null
    }
    const finalRect = new THREE.Line(
      new THREE.BufferGeometry().setFromPoints([A, B, C, D, A]),
      new THREE.LineBasicMaterial({ color: 0xffff00 })
    )
    
    // 获取 finalRect 的中心点
    const finalRect_center = new THREE.Vector3();
    finalRect.geometry.computeBoundingBox();
    finalRect.geometry.boundingBox.getCenter(finalRect_center);
    // 创建长方体
    const geometry = new THREE.BoxGeometry(A.distanceTo(B),B.distanceTo(C),size.z); // 长(x)、宽(y)、高(z)
    const material = new THREE.MeshBasicMaterial({
      color: 0x00ff00,
      transparent: true,
      opacity: 0.5
    });
    material.depthWrite = false;
    const cube = new THREE.Mesh(geometry, material);
    cube.position.set(finalRect_center.x,finalRect_center.y, finalRect_center.z);
    // 假设 A 和 B 已经是 THREE.Vector3 类型
    const midpointAB = new THREE.Vector3().addVectors(A, B).multiplyScalar(0.5);
    // 让 cube 朝向这个中点（默认 Z 轴朝向目标点）
    cube.lookAt(midpointAB);
    
    // // 再绕 Y 轴旋转 90 度，把 X 轴对准目标
    cube.rotateY(-Math.PI / 2); // 视你的模型定义方向可能是正的或负的
    cube.rotateZ(-Math.PI / 2); // 视你的模型定义方向可能是正的或负的

    cube.userData.selectable = true;
    cube.userData.xx = tag++
    cube.userData.bed_id = null
    // 将 cube 对象序列化为 JSON 对象
    // const cubeData = cube.toJSON();
    // 转换为 JSON 字符串，方便存储
    // const cubeJSONString = JSON.stringify(cubeData);
    cube.updateMatrix();
    const group = new THREE.Group()
    disposeMesh(sphere)
    group.add(sphere)
    group.add(finalRect)
    group.add(cube)
    try{
      const res = await ModelApi.add({
        floor_number,
        model_data:JSON.stringify(group.toJSON())
      })
      cube.userData.id = res.data
      cubeList.push(group)
      scene.add(group);
    }catch(err){
      console.log(err)
      ElMessage.error("网络请求错误")
    }
    

    clickCount = 0
    points = []
  }
}

// 鼠标移动事件：在绘制过程中实时更新临时线条或预览矩形
function onMouseMove(event) {
  if (mode.value !== 'draw') return
  if (clickCount === 1 && tempLine) {
    const currentPoint = getMouseIntersection(event)
    if (!currentPoint) return
    tempLine.geometry.setFromPoints([points[0], currentPoint])
  }
  if (clickCount === 2 && previewLine) {
    const currentPoint = getMouseIntersection(event)
    if (!currentPoint) return
    const dir = new THREE.Vector3().subVectors(points[1], points[0]).normalize()
    const v = new THREE.Vector3().subVectors(currentPoint, points[0])
    const projLength = v.dot(dir)
    const projVec = dir.clone().multiplyScalar(projLength)
    const offset = new THREE.Vector3().subVectors(v, projVec)
    const A = points[0]
    const B = points[1]
    const C = new THREE.Vector3().addVectors(B, offset)
    const D = new THREE.Vector3().addVectors(A, offset)
    previewLine.geometry.setFromPoints([A, B, C, D, A])
  }
}

// 模式切换：重置绘制变量
function setMode(newMode) {
  mode.value = newMode
  if(selectedCube.value)
    selectedCube.value.remove(selectedCube.value.userData.outline);
  if (newMode === 'draw') {
    clickCount = 0
    points = []
    if (tempLine) {
      scene.remove(tempLine)
      tempLine = null
    }
    if (previewLine) {
      scene.remove(previewLine)
      previewLine = null
    }
  }
}

onMounted(() => {
  init()
})

onBeforeUnmount(() => {
  window.removeEventListener('resize', onWindowResize)
  renderer.domElement.removeEventListener('click', onClick)
  renderer.domElement.removeEventListener('mousemove', onMouseMove)
})
defineExpose({

})
</script>

<style scoped>
.property-panel {
  position: absolute;
  top: 50%;
  right: 10px;
  transform: translateY(-50%);
  background-color: #fff;
  padding: 10px;
  border: 1px solid #ccc;
  z-index: 3;
}

.three-container {
  position: relative;
  width: 80vw;
  height: 100vh;
  overflow: hidden;
}

.control-panel {
  position: absolute;
  top: 10px;
  left: 10px;
  z-index: 2;
}
.control-panel-right {
  position: absolute;
  top: 10px;
  right: 10px;
  z-index: 2;
}

.info {
  position: absolute;
  bottom: 10px;
  left: 10px;
  z-index: 2;
}

.loading-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(255, 255, 255, 0.8);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1;
  font-size: 1.5em;
  color: #000;
}
/* 添加下拉框样式 */
select {
  margin-right: 10px;
  padding: 5px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: white;
}
</style>
