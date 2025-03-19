// 病人信息表 API 模块

import {haveSameKeys,request} from '../common/common.js';

const model = {}


export const esTableSearchField = [
                "name",
                "address",
]
Object.assign(model,{esTableSearchField});

export const hasEsTable = true

/**
 * 默认的 Patients 对象
 */
export const Fields = {
    patientID: null, // 病人唯一标识
    name: null, // 病人姓名
    gender: null, // 性别
    dateOfBirth: null, // 出生日期
    contactNumber: null, // 联系电话
    address: null, // 地址
    emergencyContact: null, // 紧急联系人
    createdAt: null, // 创建时间
    id_card_number: null, // 身份证号
    id_card_type: null, // 证件类型
    id_card_expiry: null, // 证件有效期
};

export const FieldsInfo = {
    patientID:{
        jdbcType:"INTEGER",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"int",
            columnDefinition:"int"
        }
    },
    name:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(100)"
        }
    },
    gender:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"enum",
            columnDefinition:"enum('男性','女性','其他')"
        }
    },
    dateOfBirth:{
        jdbcType:"LOCAL_DATE",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"date",
            columnDefinition:"date"
        }
    },
    contactNumber:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(15)"
        }
    },
    address:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"text",
            columnDefinition:"text"
        }
    },
    emergencyContact:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(15)"
        }
    },
    createdAt:{
        jdbcType:"LOCAL_DATE_TIME",
        isNullable:true,
        defaultValue:"CURRENT_TIMESTAMP",
        type:{
            columnType:"timestamp",
            columnDefinition:"timestamp"
        }
    },
    id_card_number:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(18)"
        }
    },
    id_card_type:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"enum",
            columnDefinition:"enum('身份证','护照','港澳台证','其他')"
        }
    },
    id_card_expiry:{
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
    patientID: "病人唯一标识",
    name: "病人姓名",
    gender: "性别",
    dateOfBirth: "出生日期",
    contactNumber: "联系电话",
    address: "地址",
    emergencyContact: "紧急联系人",
    createdAt: "创建时间",
    id_card_number: "身份证号",
    id_card_type: "证件类型",
    id_card_expiry: "证件有效期",
}

export const PrimaryKey = "patientID";

/**
 * 获取 Patients 列表
 */
const standardURL = "/RESTful/standard/patients";
const readerURL = "/RESTful/reader/patients";

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
const contractorURL = "/RESTful/contractor/patients";
export const contractorFields = {
    name: null, // 病人姓名
    gender: null, // 性别
    dateOfBirth: null, // 出生日期
    contactNumber: null, // 联系电话
    address: null, // 地址
    emergencyContact: null, // 紧急联系人
    id_card_number: null, // 身份证号
    id_card_type: null, // 证件类型
    id_card_expiry: null, // 证件有效期
};
export const contractorExcludeField = {
            patientID:null,
            createdAt:null,
};

export const contractorParam = {
           CPatientsController: {"update":{"id":"Integer","patients":{"type":"CPatientsParam","fields":{"Name":"String","Gender":"String","DateOfBirth":"Date","ContactNumber":"String","Address":"String","EmergencyContact":"String","Id_card_number":"String","Id_card_type":"String","Id_card_expiry":"Date"}}},"delete":{"id":"Integer"},"create":{"patients":{"type":"CPatientsParam","fields":{"Name":"String","Gender":"String","DateOfBirth":"Date","ContactNumber":"String","Address":"String","EmergencyContact":"String","Id_card_number":"String","Id_card_type":"String","Id_card_expiry":"Date"}}}},
}

/**
 * 添加 Patients
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
 * 更新 Patients
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
 * 删除 Patients
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
 * 添加 Patients
 */
export function create(data) {
    if(!haveSameKeys(data,Fields)){
        throw new Error("Patients的create请求数据结构不一致！");
    }
    data.patientID = null;
    return request({
        url: standardURL,
        method: 'post',
        data:data
    });
}

/**
 * 更新 Patients
 */
export function update(id,data) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    if(!haveSameKeys(data,Fields)){
        throw new Error("Patients的update请求数据结构不一致！");
    }
    return request({
        url: standardURL+"/"+id,
        method: 'put',
        data:data
    });
}

/**
 * 删除 Patients
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