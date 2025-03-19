// 住院管理表 API 模块

import {haveSameKeys,request} from '../common/common.js';

const model = {}



export const hasEsTable = false

/**
 * 默认的 Inpatients 对象
 */
export const Fields = {
    inpatientID: null, // 住院唯一标识
    patientID: null, // 病人唯一标识（外键）
    admissionDate: null, // 入院日期
    dischargeDate: null, // 出院日期
    roomNumber: null, // 病房号
    bedNumber: null, // 床号
    currentStatus: null, // 当前状态
};

export const FieldsInfo = {
    inpatientID:{
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
    admissionDate:{
        jdbcType:"LOCAL_DATE",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"date",
            columnDefinition:"date"
        }
    },
    dischargeDate:{
        jdbcType:"LOCAL_DATE",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"date",
            columnDefinition:"date"
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
    currentStatus:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:"入院",
        type:{
            columnType:"enum",
            columnDefinition:"enum('入院','出院','转院')"
        }
    },
}

export const FieldsName = {
    inpatientID: "住院唯一标识",
    patientID: "病人唯一标识（外键）",
    admissionDate: "入院日期",
    dischargeDate: "出院日期",
    roomNumber: "病房号",
    bedNumber: "床号",
    currentStatus: "当前状态",
}

export const PrimaryKey = "inpatientID";

/**
 * 获取 Inpatients 列表
 */
const standardURL = "/RESTful/standard/inpatients";
const readerURL = "/RESTful/reader/inpatients";

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
const contractorURL = "/RESTful/contractor/inpatients";
export const contractorFields = {
    patientID: null, // 病人唯一标识（外键）
    admissionDate: null, // 入院日期
    dischargeDate: null, // 出院日期
    roomNumber: null, // 病房号
    bedNumber: null, // 床号
    currentStatus: null, // 当前状态
};
export const contractorExcludeField = {
            inpatientID:null,
};

export const contractorParam = {
           CInpatientsController: {"update":{"inpatientsMixParam":{"type":"CUInpatientsMixParam","fields":{"inpatientsParam":{"type":"CInpatientsParam","fields":{"PatientID":"Integer","AdmissionDate":"Date","DischargeDate":"Date","RoomNumber":"String","BedNumber":"Integer","CurrentStatus":"String"}},"TransactionID":"Integer"}},"id":"Integer"},"delete":{"id":"Integer"},"create":{"inpatientsMixParam":{"type":"CCInpatientsMixParam","fields":{"inpatientsParam":{"type":"CInpatientsParam","fields":{"PatientID":"Integer","AdmissionDate":"Date","DischargeDate":"Date","RoomNumber":"String","BedNumber":"Integer","CurrentStatus":"String"}},"financialrecordsParam":{"type":"CFinancialrecordsMinParam","fields":{"Amount":"BigDecimal","PaymentMethod":"String","Description":"String"}},"TransactionID":"Integer"}}}},
}

/**
 * 添加 Inpatients
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
 * 更新 Inpatients
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
 * 删除 Inpatients
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
 * 添加 Inpatients
 */
export function create(data) {
    if(!haveSameKeys(data,Fields)){
        throw new Error("Inpatients的create请求数据结构不一致！");
    }
    data.inpatientID = null;
    return request({
        url: standardURL,
        method: 'post',
        data:data
    });
}

/**
 * 更新 Inpatients
 */
export function update(id,data) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    if(!haveSameKeys(data,Fields)){
        throw new Error("Inpatients的update请求数据结构不一致！");
    }
    return request({
        url: standardURL+"/"+id,
        method: 'put',
        data:data
    });
}

/**
 * 删除 Inpatients
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