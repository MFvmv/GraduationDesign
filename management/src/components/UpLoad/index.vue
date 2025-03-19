<template>
    <div style="overflow-x: scroll;/* 仅水平滚动 */width: 100%;height: 100%;display: flex;flex-wrap: nowrap;">
        <el-upload
        class="custom-upload"
        :action="uploadUrl"
        :data="dataObj"
        :multiple="true"
        name="file"
        list-type="picture-card"
        :on-success="handleSuccess"
        :on-error="handleError"
        :file-list="listProxy"
        :before-upload="beforeUpload"
        :on-preview="handlePictureCardPreview"
        :on-remove="handleRemove"
        :on-progress="onProgress"
        :on-change="onChange"
        :auto-upload="true"
        >
        <template #file="{file,index}">
            <div>
                <span style="color: white; position: absolute;background-color: black;">{{file.label}}</span>
                <img class="el-upload-list__item-thumbnail" :src="file.url" alt="" />
                <span class="el-upload-list__item-actions">
                <span
                    class="el-upload-list__item-preview"
                    @click="handlePictureCardPreview(file)"
                >
                    <el-icon><zoom-in /></el-icon>
                </span>
                <span
                    v-if="!disabled"
                    class="el-upload-list__item-delete"
                    @click="handleRemove(file,index)"
                >
                    <el-icon><Delete /></el-icon>
                </span>
                </span>
            </div>
        </template>
        <el-icon><Plus /></el-icon>
        </el-upload>
    </div>
    <el-dialog append-to-body style="width: 80%;"v-model="dialogVisible">
        <img w-full style="width: 100%;" :src="dialogImageUrl" alt="Preview Image" />
    </el-dialog>
</template>

<script>
import { policy } from '@/api/oss';
import { ElMessage,ElMessageBox } from 'element-plus';

export default {
    data() {
        return {
            disabled:false,
            dialogVisible:false,
            dialogImageUrl:'',
            rawfile:null,
            // OSS 返回的策略数据
            dataObj: {
                host:''
            },
            list:[]
        };
    },
    props:{
        fileList:{
            type:Array,
            required:false,
            default:[]
        },
        success:{
            type:Function,
            required:true,
        },
        scope:{
            type:Object,
            required:false,
        },
        delete:{
            type:Function,
            required:true,
        },
    },
    mounted(){
       this.listProxy = this.fileList
    },
    computed: {
        // 上传地址直接使用 OSS 返回的 host
        uploadUrl() {
            return this.dataObj.host;
        },
        listProxy:{
            get() {
                return this.list;
            },
            set(value) {
                this.list = [...this.list,...value] // 赋值给原始数据
            }
        }
    },
    emits: ['update:fileList'],
    methods: {
        async getPolicy(file){
            const cutStr = file.name.split('.')
            const filename = String(file.uid)+"."+cutStr[cutStr.length-1]
            const response = await policy()
            const dataObj = {
                policy:response.data.policy,
                signature:response.data.signature,
                ossaccessKeyId:response.data.accessKeyId,
                key:response.data.dir +'/'+ filename,
                dir:response.data.dir,
                host:response.data.host
            }
            return dataObj
        },
        handleRemove(file,index){
            const host = "https://mf-oss2.oss-cn-guangzhou.aliyuncs.com/"
            const ossPath = file.url.replace(host,'')
            this.delete(file,this.scope,{ossPath,index,filelist:this.listProxy})
            // console.log(file)
            // console.log(files)
        },
        handlePictureCardPreview(file){
            this.dialogImageUrl = file.url
            this.dialogVisible = true
        },
        handleSuccess(response, file, fileList) {
            ElMessage.success("上传成功")
            ElMessageBox.prompt('请输入影像别名', '', {
                confirmButtonText: '确认',
                cancelButtonText: '取消',
            })
            .then(({ value }) => {
                ElMessage.success(`别名为:${value}`)
                this.listProxy = [{
                    name:file.name,
                    label:value,
                    url:(this.dataObj.host.replace('http://','https://')+'/'+this.dataObj.key)
                }]
                this.success(this.listProxy,this.scope)
                this.$emit('update:fileList',[...this.listProxy])
            })
            .catch(() => {
                ElMessage.info("不起别名")
            })
        },
        handleError(err, file, fileList) {
            console.error("上传失败：", err);
            ElMessage.error("上传失败")
        },
        async beforeUpload(file) {
            try {
                this.dataObj = await this.getPolicy(file);
                return true; // 继续上传
            } catch (error) {
                console.error('获取上传策略失败：', error);
                ElMessage.error('获取上传策略失败，无法上传文件')
                return false; // 阻止上传
            }
        }
    },
    };
</script>


<style scoped>
/* 使用 /deep/ */
.custom-upload /deep/ .el-upload-list--picture-card {
  /* 您的自定义样式 */
  flex-wrap:nowrap !important;
}

</style>
  