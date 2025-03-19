// 挂号与预约表 API 模块

import {haveSameKeys,request} from '../common/common.js';

const model = {}



export const hasEsTable = false

/**
 * 默认的 Appointments 对象
 */
export const Fields = {
    appointmentID: null, // 挂号唯一标识
    patientID: null, // 病人唯一标识（外键）
    appointmentDate: null, // 预约日期
    appointmentTime: null, // 预约时间
    department: null, // 科室
    doctorName: null, // 医生姓名
    status: null, // 预约状态
};

export const FieldsInfo = {
    appointmentID:{
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
    appointmentDate:{
        jdbcType:"LOCAL_DATE",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"date",
            columnDefinition:"date"
        }
    },
    appointmentTime:{
        jdbcType:"LOCAL_TIME",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"time",
            columnDefinition:"time"
        }
    },
    department:{
        jdbcType:"STRING",
        isNullable:false,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(50)"
        }
    },
    doctorName:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:undefined,
        type:{
            columnType:"varchar",
            columnDefinition:"varchar(100)"
        }
    },
    status:{
        jdbcType:"STRING",
        isNullable:true,
        defaultValue:"已计划",
        type:{
            columnType:"enum",
            columnDefinition:"enum('已计划','已完成','取消')"
        }
    },
}

export const FieldsName = {
    appointmentID: "挂号唯一标识",
    patientID: "病人唯一标识（外键）",
    appointmentDate: "预约日期",
    appointmentTime: "预约时间",
    department: "科室",
    doctorName: "医生姓名",
    status: "预约状态",
}

export const PrimaryKey = "appointmentID";

/**
 * 获取 Appointments 列表
 */
const standardURL = "/RESTful/standard/appointments";
const readerURL = "/RESTful/reader/appointments";

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
 * 添加 Appointments
 */
export function create(data) {
    if(!haveSameKeys(data,Fields)){
        throw new Error("Appointments的create请求数据结构不一致！");
    }
    data.appointmentID = null;
    return request({
        url: standardURL,
        method: 'post',
        data:data
    });
}

/**
 * 更新 Appointments
 */
export function update(id,data) {
    if(id===undefined || data===undefined) throw Error("必填参数未传入");
    if(!haveSameKeys(data,Fields)){
        throw new Error("Appointments的update请求数据结构不一致！");
    }
    return request({
        url: standardURL+"/"+id,
        method: 'put',
        data:data
    });
}

/**
 * 删除 Appointments
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