package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RFinancialrecordsService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.FinancialrecordsMapper;
import com.hospital.mbg.model.FinancialrecordsExample;
import com.hospital.mbg.model.Financialrecords;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 财务管理表 服务实现类
 * 该类依赖于 FinancialrecordsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RFinancialrecordsServiceImpl implements  RFinancialrecordsService {
    @Autowired
    private FinancialrecordsMapper financialrecordsMapper;

    @Override
    public List<Financialrecords> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FinancialrecordsExample financialrecordsExample = new FinancialrecordsExample();
        //添加顺序
        financialrecordsExample.setOrderByClause("TransactionDate DESC");
        // 执行查询
        List<Financialrecords> result =
        (List<Financialrecords>)
            ReflectionUtils.callIfExists(
                financialrecordsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{FinancialrecordsExample.class},
                new Object[]{financialrecordsExample}
            );
        return result;
    }

    @Override
    public List<Financialrecords> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FinancialrecordsExample financialrecordsExample = new FinancialrecordsExample();
        //添加顺序
        financialrecordsExample.setOrderByClause("TransactionDate DESC");
        // 添加条件
        FinancialrecordsExample.Criteria criteria = financialrecordsExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("TransactionID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andTransactionIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("PatientID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andPatientIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Amount"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andAmountEqualTo",value));
            criteria.when(field.equalsIgnoreCase("TransactionDate"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andTransactionDateEqualTo",value));
            criteria.when(field.equalsIgnoreCase("PaymentMethod"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andPaymentMethodEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Description"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andDescriptionEqualTo",value));
            criteria.when(field.equalsIgnoreCase("PaymentStatus"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andPaymentStatusEqualTo",value));
            criteria.when(field.equalsIgnoreCase("OrderNumber"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andOrderNumberEqualTo",value));
        // 执行查询
        List<Financialrecords> result =
        (List<Financialrecords>)
            ReflectionUtils.callIfExists(
                financialrecordsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{FinancialrecordsExample.class},
                new Object[]{financialrecordsExample}
            );
        return result;
    }

}

