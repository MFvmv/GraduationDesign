// 病历管理表 API 模块

import {haveSameKeys,request} from '../common/common.js';

const model = {}



export const hasEsTable = false

/**
 * 默认的 Medicalrecords 对象
 */
export const Fields = {
    recordID: null, // 病历唯一标识
    patientID: null, // 病人唯一标识（外键）
    diagnosis: null, // 诊断记录
    treatmentPlan: null, // 治疗计划
    testReports: null, // 检查报告
    recordDate: null, // 病历日期
    image_data: null, // 影像数据
};

export const FieldsInfo = {
    recordID:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    patientID:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    diagnosis:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"text",
            columnDefinition:"text"
        }
    },
    treatmentPlan:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"text",
            columnDefinition:"text"
        }
    },
    testReports:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"text",
            columnDefinition:"text"
        }
    },
    recordDate:{
        jdbcType:"LOCAL_DATE_TIME",
        isNullable:false,
        defaultValue:"CURRENT_TIMESTAMP",
        type:{
            columnType:"datetime",
            columnDefinition:"datetime"
        }
    },
    image_data:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"json",
            columnDefinition:"json"
        }
    },
}

export const FieldsName = {
    recordID: "病历唯一标识",
    patientID: "病人唯一标识（外键）",
    diagnosis: "诊断记录",
    treatmentPlan: "治疗计划",
    testReports: "检查报告",
    recordDate: "病历日期",
    image_data: "影像数据",
}

export const PrimaryKey = "recordID";

/**
 * 获取 Medicalrecords 列表
 */
const standardURL = "/RESTful/standard/medicalrecords";
const readerURL = "/RESTful/reader/medicalrecords";

//---------------------------------------reader---------------------------------
export function list({pageSize=null,pageNum=null}={}) {
    return request({
        url: readerURL+"/list",
        method: 'get',
        params:{
            pageSize:pageSize,
            pageNum:pageNum
        }
    });
}

export function searchByField(value,{field=null,pageSize=null,pageNum=null}={}) {
    if(value===undefined) throw Error("必填参数未传入");
    return request({
        url: readerURL+"/searchByField",
        method: 'get',
        params:{
            value:value,
            field:field,
            pageSize:pageSize,
            pageNum:pageNum
        }
    });
}
export const hasContractor = false
//---------------------------------------standard---------------------------------
export function getAll() {
    return request({
        url: standardURL,
        method: 'get'
    });
}

export function getById(id) {
    if(id===undefined) throw Error("必填参数未传入");
    return request({
        url: standardURL+"/"+id,
        method: 'get'
    });
}

/**
 * 添加 Medicalrecords
 */
export function create(data) {
    if(!haveSameKeys(data,Fields)){
        throw new Error("Medicalrecords的create请求数据结构不一致！");
    }
    data.recordID = null;
    return request({
        url: standardURL,
        method: 'post',
        data:data
    });
}

/**
 * 更新 Medicalrecords
 */
export function update(id,data) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    if(!haveSameKeys(data,Fields)){
        throw new Error("Medicalrecords的update请求数据结构不一致！");
    }
    return request({
        url: standardURL+"/"+id,
        method: 'put',
        data:data
    });
}

/**
 * 删除 Medicalrecords
 */
export function _delete(id){
    if(id===undefined) throw Error("必填参数未传入");
    return request({
        url: standardURL+"/"+id,
        method: 'delete'
    });
}
Object.assign(model,{
    hasEsTable,
    Fields,
    FieldsInfo,
    FieldsName,
    PrimaryKey,
    hasContractor,
    list,
    searchByField,
    getById,
    create,
    update,
    _delete
});
export default model;