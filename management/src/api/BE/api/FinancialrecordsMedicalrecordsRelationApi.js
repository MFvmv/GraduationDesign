// 财务记录与病历关系表 API 模块

import {haveSameKeys,request} from '../common/common.js';

const model = {}



export const hasEsTable = false

/**
 * 默认的 FinancialrecordsMedicalrecordsRelation 对象
 */
export const Fields = {
    transactionID: null, // 财务记录唯一标识（外键）
    recordID: null, // 病历唯一标识（外键）
};

export const FieldsInfo = {
    transactionID:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    recordID:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
}

export const FieldsName = {
    transactionID: "财务记录唯一标识（外键）",
    recordID: "病历唯一标识（外键）",
}

export const PrimaryKey = "recordID";

/**
 * 获取 FinancialrecordsMedicalrecordsRelation 列表
 */
const standardURL = "/RESTful/standard/financialrecordsMedicalrecordsRelation";
const readerURL = "/RESTful/reader/financialrecordsMedicalrecordsRelation";

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
 * 添加 FinancialrecordsMedicalrecordsRelation
 */
export function create(data) {
    if(!haveSameKeys(data,Fields)){
        throw new Error("FinancialrecordsMedicalrecordsRelation的create请求数据结构不一致！");
    }
    data.recordID = null;
    return request({
        url: standardURL,
        method: 'post',
        data:data
    });
}

/**
 * 更新 FinancialrecordsMedicalrecordsRelation
 */
export function update(id,data) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    if(!haveSameKeys(data,Fields)){
        throw new Error("FinancialrecordsMedicalrecordsRelation的update请求数据结构不一致！");
    }
    return request({
        url: standardURL+"/"+id,
        method: 'put',
        data:data
    });
}

/**
 * 删除 FinancialrecordsMedicalrecordsRelation
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