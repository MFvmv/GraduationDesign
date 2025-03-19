<template>
  <div class="page-container">
    <action-bar
      v-model:searchQuery="searchQuery"
      v-model:selectValue="selectValue"
      :seachName="tablePetName"
      :selectOptions="Fields"
      :Search="handleSearch" 
      :Add="handleAdd"
    >
      <slot name="__action__"></slot>
    </action-bar>

    <!-- 表内容-->
    <el-table   ref="__table__" @scroll="handleScroll" :data="patients" style="width: 100%" row-key="id">
      <el-table-column
        v-for="(item, index) in Fields"
        :key="index"
        :prop="item.prop"
        :label="item.label"
        :ref="item.prop"
        :width="columnWidth[item.prop]"
      >
        <template #header="scope">
          <span v-if="$slots['header_'+item.prop]===undefined">{{ item.label }}</span>
          <slot :name="'header_'+item.prop" :value="item.label" :scope="scope"></slot>
        </template>
        <template #default="scope" >
          <span v-if="$slots[item.prop]===undefined">{{filterData(item.prop,scope.row[item.prop])}}</span>
          <slot :name="item.prop" :value="scope.row[item.prop]" :scope="scope"></slot>
        </template>
      </el-table-column>
      <el-table-column fixed="right" width="180">
        <template #header>
          <div class="no-drag">操作</div>
        </template>
        <template #default="scope">
          <div v-show="!operateHidden"v-if="$slots['__operate__']===undefined">
            <el-button  type="primary" size="small" @click="handleEdit(scope)">编辑</el-button>
            <el-button  type="danger" size="small" @click="handleDelete(scope)">删除</el-button>
          </div>
          <slot name="__operate__" :scope="scope"></slot>
          <slot name="__appendOperate__" :scope="scope"></slot>
        </template>
      </el-table-column>
    </el-table>
    
    <!-- 分页 -->
    <el-pagination
      v-model:current-page="pagination.page"
      v-model:page-size="pagination.pageSize"
      :total="pagination.total"
      @current-change="fetchData"
      @size-change="fetchData"
      layout="total, sizes, prev, pager, next"
    />
  </div>
</template>

<script>
import ActionBar from '@/components/Table/ActionBar.vue';
import Sortable from "sortablejs";
import Lodash from "lodash";

const COLUMNWIDTH_DEFAULT = 180;

export default {
  name: 'Table',
  props:{
    apiModule:{
      type: Object, // 指定类型为对象
      required: true, // 设置为必填项
    },
    tablePetName:{
      type: String, 
      required: true, 
    },
    Add:{
      type:Function,
      required:false
    },
    Edit:{
      type:Function,
      required:false
    },
    Delete:{
      type:Function,
      required:false
    },
    tableColumnWidth:{
      type:Object,
      required:false
    },
    filterValue:{
      type: Object, 
      required: false, 
    },
    filterType:{
      type: Array, 
      required: false, 
    },
    tableFieldValue:{
      type: Object,
      required: false,
      default:{}
    },
    operateHidden:{
      type:Boolean,
      required:false,
      default:false
    }
  },
  emits: ['update:tableColumnWidth'],
  watch: {
    tableColumnWidth:{
      handler(newVal, oldVal) {
        this.columnWidth = newVal
      },
      deep: true, // 监听对象内部变化
    },
  },
  components: {
    ActionBar,
  },
  data() {
    return {
      selectValue:this._selectValue,
      Fields:[...this._Fields],
      patients: null,
      pagination: {
        page: 1,
        pageSize: 10,
        total: 0
      },
      isSearching: false,
      columnWidth:this._columnWidth
    };
  },
  setup(props){
    const {FieldsName,PrimaryKey,list,searchByField,Fields,FieldsInfo} = props.apiModule
    const FieldsNameInit = Object.assign(FieldsName,props.tableFieldValue)
    const _Fields = Object.entries(FieldsNameInit).map(([key, value]) => ({ prop: key, label: value }))
    const _selectValue = PrimaryKey
    const _columnWidth = Object.fromEntries(Object.keys(Fields).map((key) => [key, COLUMNWIDTH_DEFAULT]));
    return{
      api:{list,searchByField},
      _selectValue,
      _Fields,
      _columnWidth,
      _FieldsInfo:FieldsInfo
    }
  },
  mounted() {
    this.$emit('update:tableColumnWidth', {...this._columnWidth})
    this.fetchData();
    let from = null;
    this.$nextTick(() => {
      const headerRow = this.$refs.__table__.$el.querySelector('.el-table__header-wrapper table thead tr');
      if (headerRow) {
        // 绑定列拖拽：获取表头行 thead tr
        Sortable.create(headerRow, {
          animation: 150,
          filter: 'th .no-drag',
          ghostClass: 'sortable-drag',
          onStart:(evt)=>{
            from = Array.from(evt.from.children);
          },
          onEnd:(evt)=>{
            // 清空原本的 container
            const container = evt.from;
            container.innerHTML = '';  // 清空容器中的所有元素
            // 按新顺序重新插入元素
            from.forEach(item => {
              container.appendChild(item);  // 使用 appendChild 按照新的顺序添加元素
            });
            if(from[evt.newDraggableIndex].querySelectorAll("th .no-drag").length==0 && from[evt.oldDraggableIndex].querySelectorAll("th .no-drag").length==0){
              const {min,max} = evt.oldDraggableIndex>evt.newDraggableIndex?{min:evt.newDraggableIndex,max:evt.oldDraggableIndex}:{min:evt.oldDraggableIndex,max:evt.newDraggableIndex}
                const tmp = this.Fields[min]
                this.Fields[min] = this.Fields[max]
                this.Fields[max] = tmp
            }
          }
          });
      } else {
        console.warn("未找到表头行，无法绑定列拖拽。");
      }
      // 绑定行拖拽：获取表体 tbody
      // const tbody = document.querySelectorAll('.el-table__body-wrapper tbody')[1];
      // if (tbody) {
      //   Sortable.create(tbody, {
      //     animation: 150,
      //     ghostClass: 'sortable-drag',
      //     onEnd: () => {
      //       const newOrder = Array.from(tbody.children).map(tr => tr.getAttribute('data-row-key'));
      //       this.patients.sort((a, b) => newOrder.indexOf(String(a.id)) - newOrder.indexOf(String(b.id)));
      //     }
      //   });
      // } else {
      //   console.warn("未找到表体，无法绑定行拖拽。");
      // }
    });
  },
  methods: {
    handleSearch(searchQuery, selectValue) {
      if (searchQuery === ""){
        this.isSearching = false;
        this.fetchData()
      }else{
        this.api.searchByField(searchQuery, { field: selectValue, pageSize: this.pagination.pageSize, pageNum: this.pagination.page }).then(res => {
          this.patients = res.data.list;
          this.pagination.total = res.data.total;
        }).catch(error => {
            console.log(error);
        });
        this.isSearching = true;
      }
      
    },
    handleAdd() {
      this.Add?.();
      this.fetchData();
    },
    handleEdit(scope) {
      this.Edit?.(scope)
      this.fetchData();
    },
    handleDelete(scope) {
      this.Delete?.(scope)
      this.fetchData();
    },
    fetchData() {
      if (this.isSearching) {
        this.handleSearch(this.searchQuery, this.selectValue);
      } else {
        this.api.list({ pageSize: this.pagination.pageSize, pageNum: this.pagination.page }).then(res => {
          this.patients = res.data.list;
          this.pagination.total = res.data.total;
        }).catch(error => {
          console.log(error);
        });
      }
    },
    handleScroll(event){
     
    },
    filterData(prop,value){
      let result = value
      if(this.filterType !== undefined){
        this.filterType.every((item)=>{
          if(("math" in item) && Lodash.isMatch(this._FieldsInfo[prop],item.math)){
            result = item.fun(prop,value)
            return false
          }
          if("maths" in item){
            let stop = false
            item.maths.every((math)=>{
              if(Lodash.isMatch(this._FieldsInfo[prop],math)){
                result = item.fun(prop,value)
                stop = true
                return false
              }
              return true;
            })
            if(stop) return false;
          }
          return true;
        })
      }
      if(this.filterValue !== undefined &&(prop in this.filterValue)){
        result = this.filterValue[prop](value)
      }
      return result
    }
  }
}
</script>

<style scoped>
.sortable-drag {
  opacity: 0.7;
}
.no-show{
  display: none !important;
  height: 0px !important;
}
</style>
