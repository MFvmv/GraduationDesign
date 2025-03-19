<template>
    <div class="search-bar container">
        <el-input @input="handleInput" v-model="searchQuery" :placeholder="'搜索'+seachName" style="width: 200px; margin-right: 10px"></el-input>
        <el-button type="primary" @click="handleSearch">{{searchQuery===""?"刷新":"搜索"}}</el-button>
        <el-button type="success" @click="handleAdd">新增{{seachName}}</el-button>
        <span style="margin-right: 10px;">
            <span style="margin-left: 20px;color: gray;">搜索字段: </span>
            <el-select style="width: 100px;" v-model="selected"  @change="handleChange" placeholder="请选择">
                <el-option
                    v-for="item in options"
                    :label="item.label"
                    :value="item.prop"
                    @change=""
                />
            </el-select>
        </span>
        <slot></slot> <!-- 渲染插槽内容 -->
    </div>
</template>

<script>
export default {
    name: 'ActionBar',
    props:{
        seachName:{
            type:String,
            required:true
        },
        Search:{
            type:Function,
            required:true
        },
        Add:{
            type:Function,
            required:true
        },
        selectOptions:{
            type:Array,
            required:true
        },
        selectValue:{
            type:String,
            required:false
        },
        searchQuery:{
            type:String,
            required:true
        }
    },
    emits: ['update:searchQuery','update:selectValue'],
    data() {
        return {
            selected: this.selectValue, // 设置默认值
            options:[...this.selectOptions],
            searchQuery: ''
        };
    },
    methods: {
        handleSearch() {
            this.Search(this.searchQuery,this.selected);
        },
        handleAdd() {
            this.Add();
        },
        handleChange(value){
            this.$emit('update:selectValue', value)
        },
        handleInput(value){
            this.$emit('update:searchQuery', value)
        },
        logSlotContent() {
            console.log(this.$slots.default()); // 打印插槽内容的 VNode 数组
        }
    },
}
</script>

<style>
.container > * {
  margin-top: 5px;
}
</style>