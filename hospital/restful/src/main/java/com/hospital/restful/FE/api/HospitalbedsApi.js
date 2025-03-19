// 病床管理表 API 模块

import {haveSameKeys,request} from '../common/common.js';

const model = {}



export const hasEsTable = false

/**
 * 默认的 Hospitalbeds 对象
 */
export const Fields = {
    bedID: null, // 病床唯一标识
    roomNumber: null, // 病房号
    bedNumber: null, // 床号
    bedStatus: null, // 病床状态
    patientID: null, // 当前占用该床的病人ID
    lastUpdated: null, // 最后更新时间
};

export const FieldsInfo = {
    bedID:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    roomNumber:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(10)"
        }
    },
    bedNumber:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    bedStatus:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:"空闲",
        type:{
            columnType:"enum",
            columnDefinition:"enum('空闲','占用','维修中')"
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
    lastUpdated:{
        jdbcType:"LOCAL_DATE_TIME",
        isNullable:false,
        defaultValue:"CURRENT_TIMESTAMP",
        type:{
            columnType:"datetime",
            columnDefinition:"datetime"
        }
    },
}

export const FieldsName = {
    bedID: "病床唯一标识",
    roomNumber: "病房号",
    bedNumber: "床号",
    bedStatus: "病床状态",
    patientID: "当前占用该床的病人ID",
    lastUpdated: "最后更新时间",
}

export const PrimaryKey = "bedID";

/**
 * 获取 Hospitalbeds 列表
 */
const standardURL = "/RESTful/standard/hospitalbeds";
const readerURL = "/RESTful/reader/hospitalbeds";

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
 * 添加 Hospitalbeds
 */
export function create(data) {
    if(!haveSameKeys(data,Fields)){
        throw new Error("Hospitalbeds的create请求数据结构不一致！");
    }
    data.bedID = null;
    return request({
        url: standardURL,
        method: 'post',
        data:data
    });
}

/**
 * 更新 Hospitalbeds
 */
export function update(id,data) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    if(!haveSameKeys(data,Fields)){
        throw new Error("Hospitalbeds的update请求数据结构不一致！");
    }
    return request({
        url: standardURL+"/"+id,
        method: 'put',
        data:data
    });
}

/**
 * 删除 Hospitalbeds
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