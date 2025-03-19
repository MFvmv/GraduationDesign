package com.hospital.restful.modules.contractor.utils;

import com.hospital.mbg.mapper.FinancialrecordsMapper;
import com.hospital.mbg.model.Financialrecords;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class FinancialRecordsUtil {
    /**
     * 封装财务记录与关联表插入的通用逻辑。
     *
     * @param mixParam                    包含 TransactionID 和财务参数对象的混合参数对象，
     *                                    要求有 getTransactionID() 和 getFinancialrecordsParam() 方法
     * @param consumptionObj              关联对象，要求有 PatientID 属性，以及消费记录标识属性（名称由 consumptionPropertyName 指定）
     * @param consumptionPropertyName     关联表中除 TransactionID 外对应的属性名称，
     *                                    该属性在 consumptionObj 中也存在
     * @param financialrecordsMapper      用于插入 Financialrecords 的 Mapper（返回受影响行数）
     * @param relationMapper              用于插入关联表记录的 Mapper（返回受影响行数）
     * @param relationClass               关联表记录的 Class 类型（例如 FinancialrecordsDrugconsumptionRelation.class）
     * @param <T>                         关联对象的类型
     * @return 成功返回 true，否则返回 false（同时标记事务回滚）
     */
    public static <T> boolean processFinancialRecordsAndRelation(
            Object mixParam,
            Object consumptionObj,
            String consumptionPropertyName,
            FinancialrecordsMapper financialrecordsMapper,
            Object relationMapper,
            Class<T> relationClass
    ){return processFinancialRecordsAndRelation(
             mixParam,
             consumptionObj,
             consumptionPropertyName,
             financialrecordsMapper,
             relationMapper,
             relationClass,
             Integer.class
    );}
    public static <T,K> boolean processFinancialRecordsAndRelation(
            Object mixParam,
            Object consumptionObj,
            String consumptionPropertyName,
            FinancialrecordsMapper financialrecordsMapper,
            Object relationMapper,
            Class<T> relationClass,
            Class<K> KeyType
    ) {

        try {
            // 1. 通过反射获取 mixParam 中的 TransactionID
            Method getTransactionID = mixParam.getClass().getMethod("getTransactionID");
            K transactionID = (K) getTransactionID.invoke(mixParam);

            // 2. 如果 TransactionID 为 null，则创建新的 Financialrecords 记录
            if (transactionID == null) {
                Financialrecords financialrecords = new Financialrecords();
                // 从 mixParam 获取财务参数对象，并复制属性到 financialrecords
                Method getFinancialrecordsParam = mixParam.getClass().getMethod("getFinancialrecordsParam");
                Object financialrecordsParam = getFinancialrecordsParam.invoke(mixParam);
                BeanUtils.copyProperties(financialrecordsParam,financialrecords);
                // 从 consumptionObj 获取 PatientID（假设属性名为 "PatientID"）
                Method getPatientID = consumptionObj.getClass().getMethod("getPatientID");
                K patientID = (K) getPatientID.invoke(consumptionObj);
                Method setPatientID = financialrecords.getClass().getMethod("setPatientID",KeyType);
                setPatientID.invoke(financialrecords,patientID);
                System.out.println(financialrecords.toString());
                // 插入 financialrecords 记录
                if (financialrecordsMapper.insertSelective(financialrecords) <= 0) {
                    TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                    return false;
                }
                // 更新 transactionID 为新生成的值
                Method getTransactionID1 = financialrecords.getClass().getMethod("getTransactionID");
                transactionID = (K) getTransactionID1.invoke(financialrecords);
            }
            Method getConsumptionPropertyName = consumptionObj.getClass().getMethod("get"+consumptionPropertyName);
            K consumptionValue =  (K)getConsumptionPropertyName.invoke(consumptionObj);
            return processFinancialRelation(
                    transactionID,
                    consumptionValue,
                    consumptionPropertyName,
                    relationMapper,
                    "insertSelective",
                    relationClass,
                    KeyType
            );
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    public static <T,K> boolean  processFinancialRelation(
            K transactionID,
            K consumptionValue,
            String consumptionPropertyName,
            Object relationMapper,
            Class<T> relationClass
    ){  // 假设 KeyType 是 K 的实际类型
        try {
            String operate = "updateByPrimaryKeySelective";
            Class<K> keyType = (Class<K>) transactionID.getClass();
            Method selectByPrimaryKey = relationMapper.getClass().getMethod("selectByPrimaryKey", keyType);
            Object result = selectByPrimaryKey.invoke(relationMapper, consumptionValue);
            if(result==null){
                operate = "insertSelective";
            }
            return  processFinancialRelation(
                    transactionID,
                    consumptionValue,
                    consumptionPropertyName,
                    relationMapper,
                    operate,
                    relationClass,
                    keyType
            );
        } catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

    public static <T,K> boolean  processFinancialRelation(
            K transactionID,
            K consumptionValue,
            String consumptionPropertyName,
            Object relationMapper,
            String relationMapperMethod,
            Class<T> relationClass,
            Class<K> KeyType
    ){
        try {
            // 3. 创建关联表记录对象
            T relationObj = relationClass.getDeclaredConstructor().newInstance();
            // 设置关联对象中的 TransactionID 属性（假设属性名称为 "TransactionID"）
            Method setTransactionID = relationObj.getClass().getMethod("setTransactionID", KeyType);
            setTransactionID.invoke(relationObj, transactionID);
            // 从 consumptionObj 获取对应消费记录的值，属性名称由 consumptionPropertyName 指定
            Method setConsumptionValue = relationObj.getClass().getMethod("set" + consumptionPropertyName, KeyType);
            setConsumptionValue.invoke(relationObj, consumptionValue);
            Method Selective = relationMapper.getClass().getMethod(relationMapperMethod, relationObj.getClass());
            // 4. 插入关联记录
            if ((Integer) Selective.invoke(relationMapper, relationObj) <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }
}
