// 财务管理表 API 模块

import {haveSameKeys,request} from '../common/common.js';

const model = {}



export const hasEsTable = false

/**
 * 默认的 Financialrecords 对象
 */
export const Fields = {
    transactionID: null, // 财务记录唯一标识
    patientID: null, // 病人唯一标识（外键）
    amount: null, // 金额
    transactionDate: null, // 交易日期
    paymentMethod: null, // 支付方式
    description: null, // 描述
    paymentStatus: null, // 支付状态
    orderNumber: null, // 订单号
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
    patientID:{
        jdbcType:"INTEGER",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    amount:{
        jdbcType:"BIG_DECIMAL",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"decimal",
            columnDefinition:"decimal(10,2)"
        }
    },
    transactionDate:{
        jdbcType:"LOCAL_DATE",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"date",
            columnDefinition:"date"
        }
    },
    paymentMethod:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"enum",
            columnDefinition:"enum('现金','银行卡','支付宝')"
        }
    },
    description:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"text",
            columnDefinition:"text"
        }
    },
    paymentStatus:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:"未支付",
        type:{
            columnType:"enum",
            columnDefinition:"enum('已支付','未支付')"
        }
    },
    orderNumber:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(64)"
        }
    },
}

export const FieldsName = {
    transactionID: "财务记录唯一标识",
    patientID: "病人唯一标识（外键）",
    amount: "金额",
    transactionDate: "交易日期",
    paymentMethod: "支付方式",
    description: "描述",
    paymentStatus: "支付状态",
    orderNumber: "订单号",
}

export const PrimaryKey = "transactionID";

/**
 * 获取 Financialrecords 列表
 */
const standardURL = "/RESTful/standard/financialrecords";
const readerURL = "/RESTful/reader/financialrecords";

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
 * 添加 Financialrecords
 */
export function create(data) {
    if(!haveSameKeys(data,Fields)){
        throw new Error("Financialrecords的create请求数据结构不一致！");
    }
    data.transactionID = null;
    return request({
        url: standardURL,
        method: 'post',
        data:data
    });
}

/**
 * 更新 Financialrecords
 */
export function update(id,data) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    if(!haveSameKeys(data,Fields)){
        throw new Error("Financialrecords的update请求数据结构不一致！");
    }
    return request({
        url: standardURL+"/"+id,
        method: 'put',
        data:data
    });
}

/**
 * 删除 Financialrecords
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