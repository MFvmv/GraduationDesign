// 药品消耗记录表 API 模块

import {haveSameKeys,request} from '../common/common.js';

const model = {}



export const hasEsTable = false

/**
 * 默认的 Drugconsumption 对象
 */
export const Fields = {
    consumptionID: null, // 药品消耗唯一标识
    drugID: null, // 药品唯一标识（外键）
    patientID: null, // 病人唯一标识（外键）
    quantityUsed: null, // 使用数量
    lastUpdated: null, // 更新时间
    count: null, // 用时总量
};

export const FieldsInfo = {
    consumptionID:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    drugID:{
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
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    quantityUsed:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    lastUpdated:{
        jdbcType:"LOCAL_DATE_TIME",
        isNullable:false,
        defaultValue:"CURRENT_TIMESTAMP",
        type:{
            columnType:"datetime",
            columnDefinition:"datetime"
        }
    },
    count:{
        jdbcType:"INTEGER",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
}

export const FieldsName = {
    consumptionID: "药品消耗唯一标识",
    drugID: "药品唯一标识（外键）",
    patientID: "病人唯一标识（外键）",
    quantityUsed: "使用数量",
    lastUpdated: "更新时间",
    count: "用时总量",
}

export const PrimaryKey = "consumptionID";

/**
 * 获取 Drugconsumption 列表
 */
const standardURL = "/RESTful/standard/drugconsumption";
const readerURL = "/RESTful/reader/drugconsumption";

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
 * 添加 Drugconsumption
 */
export function create(data) {
    if(!haveSameKeys(data,Fields)){
        throw new Error("Drugconsumption的create请求数据结构不一致！");
    }
    data.consumptionID = null;
    return request({
        url: standardURL,
        method: 'post',
        data:data
    });
}

/**
 * 更新 Drugconsumption
 */
export function update(id,data) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    if(!haveSameKeys(data,Fields)){
        throw new Error("Drugconsumption的update请求数据结构不一致！");
    }
    return request({
        url: standardURL+"/"+id,
        method: 'put',
        data:data
    });
}

/**
 * 删除 Drugconsumption
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