<template>
  <el-dialog 
        :title="title" 
        v-model="dialogVisible"
        width="70%"
        :before-close="handleClose"
    >
    <FormRender 
    v-model="formValues"
    :schema="schema"
    :schemaContext="schemaContext"
    ref="formRef" />
    <div style="text-align: center;">
      <el-button :loading="submitLoading" @click="handleSubmit">提交</el-button>
      <el-button type="primary" @click="resetFields">重置</el-button>
    </div>
  </el-dialog>
</template>
  
<script>
  import { ref} from 'vue'

  export default {
    props:{
      title:{
          type: String, 
          required: false,
      },
      visible:{
          type: String, 
          required: true,
      },
      selectComponent:{
          type: String, 
          required: true,
      },
      item:{
        type: Array, 
        required: true,
      },
      submit:{
        type: Function, 
        required: false,
      },
      schemaContext:{
        type: Object, 
        required: false,
      },
      initialValues:{
        type: Object, 
        required: false,
      }
    },
    watch: {
      // 监听 props.initialValues 的变化
      initialValues: {
        handler(newVal) {
          this.formValues = Object.assign({},newVal)
        },
        deep: true,
      }
    },
    computed: {
        dialogVisible: {
            get() {
                return this.visible;
            },
            set(value) {
                this.$emit('update:visible', value);
            }
        }
    },
    data() {
      return {
        submitLoading:false,
      }
    },
    setup(props){
      const formRef = ref()
      formRef.initialValues = Object.assign({},props.initialValues)
      const formValues = ref({})
      const schema = {
        labelWidth: 150,
        labelAlign: 'right',
        size: 'default',
        items: props.item
      }
      return{
        formRef,
        schema,
        formValues
      }
    },
    mounted(){
      
    },
    methods:{
      async handleSubmit(){
        this.submitLoading = true
        try {
            await this.formRef.validate()
            const result = await this.submit(this.formValues,this.initialValues)
            if(result){
              this.formRef.resetFields()
              this.submitLoading = false
              this.dialogVisible = false
            }else{
              this.submitLoading = false
            }
        } catch (error) {
          console.error("表单验证失败", error)  
          this.submitLoading = false
        }
      },
      resetFields(){
        this.formRef.resetFields()
      }
    }
  }
</script>
  