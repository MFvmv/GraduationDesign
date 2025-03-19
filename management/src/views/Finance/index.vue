<template>
<h2>财务管理</h2>
<el-segmented 
v-model="segmentedValue" 
:options="options" 
size="default" 
@change="handleChange"
>
    <template #default="scope">
    <div>{{ scope.item.label }}</div>
    </template>
</el-segmented>
<div v-show="segmentedValue === 1">
    <Financialrecords></Financialrecords>
</div>
</template>

<script>
import Financialrecords from './Financialrecords.vue';

export default {
    name:"MedicantManagement",
    components:{
        Financialrecords
    },
    data(){
        return{
            segmentedValue:1
        }
    },
    setup(){
        const options = [
            {
                value:1,
                label:'财务表'
            }
        ]
        return{
            options
        }
    },
    methods:{
    handleChange(val){
    
    }
    }
}
</script>

<style>

</style>