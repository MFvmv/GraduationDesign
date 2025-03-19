package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RFinancialrecordsDrugconsumptionRelationService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.FinancialrecordsDrugconsumptionRelationMapper;
import com.hospital.mbg.model.FinancialrecordsDrugconsumptionRelationExample;
import com.hospital.mbg.model.FinancialrecordsDrugconsumptionRelation;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 财务记录与药品消耗关系表 服务实现类
 * 该类依赖于 FinancialrecordsDrugconsumptionRelationMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RFinancialrecordsDrugconsumptionRelationServiceImpl implements  RFinancialrecordsDrugconsumptionRelationService {
    @Autowired
    private FinancialrecordsDrugconsumptionRelationMapper financialrecordsDrugconsumptionRelationMapper;

    @Override
    public List<FinancialrecordsDrugconsumptionRelation> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FinancialrecordsDrugconsumptionRelationExample financialrecordsDrugconsumptionRelationExample = new FinancialrecordsDrugconsumptionRelationExample();
        //添加顺序
        // 执行查询
        List<FinancialrecordsDrugconsumptionRelation> result =
        (List<FinancialrecordsDrugconsumptionRelation>)
            ReflectionUtils.callIfExists(
                financialrecordsDrugconsumptionRelationMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{FinancialrecordsDrugconsumptionRelationExample.class},
                new Object[]{financialrecordsDrugconsumptionRelationExample}
            );
        return result;
    }

    @Override
    public List<FinancialrecordsDrugconsumptionRelation> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FinancialrecordsDrugconsumptionRelationExample financialrecordsDrugconsumptionRelationExample = new FinancialrecordsDrugconsumptionRelationExample();
        //添加顺序
        // 添加条件
        FinancialrecordsDrugconsumptionRelationExample.Criteria criteria = financialrecordsDrugconsumptionRelationExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("TransactionID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andTransactionIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("ConsumptionID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andConsumptionIDEqualTo",value));
        // 执行查询
        List<FinancialrecordsDrugconsumptionRelation> result =
        (List<FinancialrecordsDrugconsumptionRelation>)
            ReflectionUtils.callIfExists(
                financialrecordsDrugconsumptionRelationMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{FinancialrecordsDrugconsumptionRelationExample.class},
                new Object[]{financialrecordsDrugconsumptionRelationExample}
            );
        return result;
    }

}

