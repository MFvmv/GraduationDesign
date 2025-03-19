import Appointments from "./api/AppointmentsApi.js";
import Drugconsumption from "./api/DrugconsumptionApi.js";
import Druginventory from "./api/DruginventoryApi.js";
import Financialrecords from "./api/FinancialrecordsApi.js";
import Hospitalbeds from "./api/HospitalbedsApi.js";
import Inpatients from "./api/InpatientsApi.js";
import Medicalrecords from "./api/MedicalrecordsApi.js";
import Patients from "./api/PatientsApi.js";
import FinancialrecordsDrugconsumptionRelationApi from "./api/FinancialrecordsDrugconsumptionRelationApi.js";
import FinancialrecordsInpatientsRelationApi from "./api/FinancialrecordsInpatientsRelationApi.js";
import FinancialrecordsMedicalrecordsRelationApi from "./api/FinancialrecordsMedicalrecordsRelationApi.js";
import {request} from './common/common.js';
export function medicalrecordsDeleteImage(id,value,ossPath) {
  return request({
    url:'/RESTful/contractor/medicalrecords/deleteImage/'+id,
    method:'delete',
    data:value,
    params:{
      ossPath
    }
  })
};
/**
 * data:{
 * outTradeNo,//商户订单号，商家自定义，保持唯一性
 * totalAmount,//订单总金额，单位为元，精确到小数点后两位
 * }
 */
export function financialrecordsProcessAlipayWebPay(data) {
  const serve =  request({
    url:'/RESTful/contractor/financialrecords/processAlipayWebPay',
    method:'post',
    data:data
  });
  return serve
};

export const apiAll = {
    Appointments,
    Drugconsumption,
    Druginventory,
    Financialrecords,
    FinancialrecordsDrugconsumptionRelationApi,
    FinancialrecordsInpatientsRelationApi,
    FinancialrecordsMedicalrecordsRelationApi,
    Hospitalbeds,
    Inpatients,
    Medicalrecords,
    Patients,
}