// 财务记录与药品消耗关系表 API 模块

import {haveSameKeys,request} from '../common/common.js';

const model = {}



export const hasEsTable = false

/**
 * 默认的 FinancialrecordsDrugconsumptionRelation 对象
 */
export const Fields = {
    transactionID: null, // 财务记录唯一标识（外键）
    consumptionID: null, // 药品消耗唯一标识（外键）
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
    consumptionID:{
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
    consumptionID: "药品消耗唯一标识（外键）",
}

export const PrimaryKey = "consumptionID";

/**
 * 获取 FinancialrecordsDrugconsumptionRelation 列表
 */
const standardURL = "/RESTful/standard/financialrecordsDrugconsumptionRelation";
const readerURL = "/RESTful/reader/financialrecordsDrugconsumptionRelation";

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
 * 添加 FinancialrecordsDrugconsumptionRelation
 */
export function create(data) {
    if(!haveSameKeys(data,Fields)){
        throw new Error("FinancialrecordsDrugconsumptionRelation的create请求数据结构不一致！");
    }
    data.consumptionID = null;
    return request({
        url: standardURL,
        method: 'post',
        data:data
    });
}

/**
 * 更新 FinancialrecordsDrugconsumptionRelation
 */
export function update(id,data) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    if(!haveSameKeys(data,Fields)){
        throw new Error("FinancialrecordsDrugconsumptionRelation的update请求数据结构不一致！");
    }
    return request({
        url: standardURL+"/"+id,
        method: 'put',
        data:data
    });
}

/**
 * 删除 FinancialrecordsDrugconsumptionRelation
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