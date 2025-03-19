export const formUpdate_callback = ()=>{
    return ({items,item,key})=>{
        if(key === 'id'){
          items.unshift({
              required: true,
              name: "id",
              hidden:true,
              component: "Input"
          })
          return {notAdd:true}
        }
    }
}