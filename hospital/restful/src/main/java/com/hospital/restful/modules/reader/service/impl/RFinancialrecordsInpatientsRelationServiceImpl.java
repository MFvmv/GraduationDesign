package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RFinancialrecordsInpatientsRelationService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.FinancialrecordsInpatientsRelationMapper;
import com.hospital.mbg.model.FinancialrecordsInpatientsRelationExample;
import com.hospital.mbg.model.FinancialrecordsInpatientsRelation;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 财务记录与住院关系表 服务实现类
 * 该类依赖于 FinancialrecordsInpatientsRelationMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RFinancialrecordsInpatientsRelationServiceImpl implements  RFinancialrecordsInpatientsRelationService {
    @Autowired
    private FinancialrecordsInpatientsRelationMapper financialrecordsInpatientsRelationMapper;

    @Override
    public List<FinancialrecordsInpatientsRelation> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FinancialrecordsInpatientsRelationExample financialrecordsInpatientsRelationExample = new FinancialrecordsInpatientsRelationExample();
        //添加顺序
        // 执行查询
        List<FinancialrecordsInpatientsRelation> result =
        (List<FinancialrecordsInpatientsRelation>)
            ReflectionUtils.callIfExists(
                financialrecordsInpatientsRelationMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{FinancialrecordsInpatientsRelationExample.class},
                new Object[]{financialrecordsInpatientsRelationExample}
            );
        return result;
    }

    @Override
    public List<FinancialrecordsInpatientsRelation> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FinancialrecordsInpatientsRelationExample financialrecordsInpatientsRelationExample = new FinancialrecordsInpatientsRelationExample();
        //添加顺序
        // 添加条件
        FinancialrecordsInpatientsRelationExample.Criteria criteria = financialrecordsInpatientsRelationExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("TransactionID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andTransactionIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("InpatientID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andInpatientIDEqualTo",value));
        // 执行查询
        List<FinancialrecordsInpatientsRelation> result =
        (List<FinancialrecordsInpatientsRelation>)
            ReflectionUtils.callIfExists(
                financialrecordsInpatientsRelationMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{FinancialrecordsInpatientsRelationExample.class},
                new Object[]{financialrecordsInpatientsRelationExample}
            );
        return result;
    }

}

