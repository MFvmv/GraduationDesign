// 药品库存管理表 API 模块

import {haveSameKeys,request} from '../common/common.js';

const model = {}



export const hasEsTable = false

/**
 * 默认的 Druginventory 对象
 */
export const Fields = {
    drugID: null, // 药品唯一标识
    drugName: null, // 药品名称
    category: null, // 药品类别
    quantity: null, // 库存数量
    unitPrice: null, // 单价
    supplierName: null, // 供应商名称
    lastUpdated: null, // 最后更新时间
    manufactureDate: null, // 药品制作日期
    expiryDate: null, // 药品有效日期
};

export const FieldsInfo = {
    drugID:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    drugName:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(100)"
        }
    },
    category:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(50)"
        }
    },
    quantity:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    unitPrice:{
        jdbcType:"BIG_DECIMAL",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"decimal",
            columnDefinition:"decimal(10,2)"
        }
    },
    supplierName:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(100)"
        }
    },
    lastUpdated:{
        jdbcType:"LOCAL_DATE_TIME",
        isNullable:true,
        defaultValue:"CURRENT_TIMESTAMP",
        type:{
            columnType:"timestamp",
            columnDefinition:"timestamp"
        }
    },
    manufactureDate:{
        jdbcType:"LOCAL_DATE",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"date",
            columnDefinition:"date"
        }
    },
    expiryDate:{
        jdbcType:"LOCAL_DATE",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"date",
            columnDefinition:"date"
        }
    },
}

export const FieldsName = {
    drugID: "药品唯一标识",
    drugName: "药品名称",
    category: "药品类别",
    quantity: "库存数量",
    unitPrice: "单价",
    supplierName: "供应商名称",
    lastUpdated: "最后更新时间",
    manufactureDate: "药品制作日期",
    expiryDate: "药品有效日期",
}

export const PrimaryKey = "drugID";

/**
 * 获取 Druginventory 列表
 */
const standardURL = "/RESTful/standard/druginventory";
const readerURL = "/RESTful/reader/druginventory";

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
export const hasContractor = true
//---------------------------------------contractor---------------------------------
const contractorURL = "/RESTful/contractor/druginventory";
export const contractorFields = {
    drugName: null, // 药品名称
    category: null, // 药品类别
    quantity: null, // 库存数量
    unitPrice: null, // 单价
    supplierName: null, // 供应商名称
    manufactureDate: null, // 药品制作日期
    expiryDate: null, // 药品有效日期
};
export const contractorExcludeField = {
            drugID:null,
            lastUpdated:null,
};

export const contractorParam = {
           CDruginventoryController: {"update":{"id":"Integer","druginventory":{"type":"CDruginventoryParam","fields":{"DrugName":"String","Category":"String","Quantity":"Integer","UnitPrice":"BigDecimal","SupplierName":"String","ManufactureDate":"Date","ExpiryDate":"Date"}}},"delete":{"id":"Integer"},"create":{"druginventory":{"type":"CDruginventoryParam","fields":{"DrugName":"String","Category":"String","Quantity":"Integer","UnitPrice":"BigDecimal","SupplierName":"String","ManufactureDate":"Date","ExpiryDate":"Date"}}}},
}

/**
 * 添加 Druginventory
 */
export function contractor_create(data,params={}) {
    if(data===undefined) throw Error("必填参数未传入");
    return request({
        url: contractorURL,
        method: 'post',
        data:data,
        params:params
    });
}

/**
 * 更新 Druginventory
 */
export function contractor_update(id,data,params={}) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    return request({
        url: contractorURL+"/"+id,
        method: 'put',
        data:data,
        params:params
    });
}

/**
 * 删除 Druginventory
 */
export function contractor_delete(id){
    if(id===undefined) throw Error("必填参数未传入");
    return request({
        url: standardURL+"/"+id,
        method: 'delete'
    });
}
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
 * 添加 Druginventory
 */
export function create(data) {
    if(!haveSameKeys(data,Fields)){
        throw new Error("Druginventory的create请求数据结构不一致！");
    }
    data.drugID = null;
    return request({
        url: standardURL,
        method: 'post',
        data:data
    });
}

/**
 * 更新 Druginventory
 */
export function update(id,data) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    if(!haveSameKeys(data,Fields)){
        throw new Error("Druginventory的update请求数据结构不一致！");
    }
    return request({
        url: standardURL+"/"+id,
        method: 'put',
        data:data
    });
}

/**
 * 删除 Druginventory
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
    contractorFields,
    contractorExcludeField,
    contractorParam,
    contractor_create,
    contractor_update,
    contractor_delete,
    list,
    searchByField,
    getById,
    create,
    update,
    _delete
});
export default model;