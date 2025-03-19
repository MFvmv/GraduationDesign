<template>
<h2>入院管理</h2>
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
    <Hospitalbeds></Hospitalbeds>
</div>
<div v-show="segmentedValue === 2">
    <Inpatients></Inpatients>
</div>
</template>

<script>
import Hospitalbeds from './Hospitalbeds.vue';
import Inpatients from './Inpatients.vue';

export default {
    name:"MedicantManagement",
    components:{
        Hospitalbeds,
        Inpatients
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
                label:'病床表'
            },
            {
                value:2,
                label:'入院记录表'
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