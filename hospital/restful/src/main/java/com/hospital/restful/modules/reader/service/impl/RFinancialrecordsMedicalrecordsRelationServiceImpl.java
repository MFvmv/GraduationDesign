package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RFinancialrecordsMedicalrecordsRelationService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.FinancialrecordsMedicalrecordsRelationMapper;
import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelationExample;
import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelation;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 财务记录与病历关系表 服务实现类
 * 该类依赖于 FinancialrecordsMedicalrecordsRelationMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RFinancialrecordsMedicalrecordsRelationServiceImpl implements  RFinancialrecordsMedicalrecordsRelationService {
    @Autowired
    private FinancialrecordsMedicalrecordsRelationMapper financialrecordsMedicalrecordsRelationMapper;

    @Override
    public List<FinancialrecordsMedicalrecordsRelation> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FinancialrecordsMedicalrecordsRelationExample financialrecordsMedicalrecordsRelationExample = new FinancialrecordsMedicalrecordsRelationExample();
        //添加顺序
        // 执行查询
        List<FinancialrecordsMedicalrecordsRelation> result =
        (List<FinancialrecordsMedicalrecordsRelation>)
            ReflectionUtils.callIfExists(
                financialrecordsMedicalrecordsRelationMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{FinancialrecordsMedicalrecordsRelationExample.class},
                new Object[]{financialrecordsMedicalrecordsRelationExample}
            );
        return result;
    }

    @Override
    public List<FinancialrecordsMedicalrecordsRelation> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        FinancialrecordsMedicalrecordsRelationExample financialrecordsMedicalrecordsRelationExample = new FinancialrecordsMedicalrecordsRelationExample();
        //添加顺序
        // 添加条件
        FinancialrecordsMedicalrecordsRelationExample.Criteria criteria = financialrecordsMedicalrecordsRelationExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("TransactionID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andTransactionIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("RecordID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andRecordIDEqualTo",value));
        // 执行查询
        List<FinancialrecordsMedicalrecordsRelation> result =
        (List<FinancialrecordsMedicalrecordsRelation>)
            ReflectionUtils.callIfExists(
                financialrecordsMedicalrecordsRelationMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{FinancialrecordsMedicalrecordsRelationExample.class},
                new Object[]{financialrecordsMedicalrecordsRelationExample}
            );
        return result;
    }

}

