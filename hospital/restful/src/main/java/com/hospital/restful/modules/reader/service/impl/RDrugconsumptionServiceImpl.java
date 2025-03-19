package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RDrugconsumptionService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.DrugconsumptionMapper;
import com.hospital.mbg.model.DrugconsumptionExample;
import com.hospital.mbg.model.Drugconsumption;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 药品消耗记录表 服务实现类
 * 该类依赖于 DrugconsumptionMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RDrugconsumptionServiceImpl implements  RDrugconsumptionService {
    @Autowired
    private DrugconsumptionMapper drugconsumptionMapper;

    @Override
    public List<Drugconsumption> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        DrugconsumptionExample drugconsumptionExample = new DrugconsumptionExample();
        //添加顺序
        drugconsumptionExample.setOrderByClause("LastUpdated DESC");
        // 执行查询
        List<Drugconsumption> result =
        (List<Drugconsumption>)
            ReflectionUtils.callIfExists(
                drugconsumptionMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{DrugconsumptionExample.class},
                new Object[]{drugconsumptionExample}
            );
        return result;
    }

    @Override
    public List<Drugconsumption> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        DrugconsumptionExample drugconsumptionExample = new DrugconsumptionExample();
        //添加顺序
        drugconsumptionExample.setOrderByClause("LastUpdated DESC");
        // 添加条件
        DrugconsumptionExample.Criteria criteria = drugconsumptionExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("ConsumptionID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andConsumptionIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("DrugID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andDrugIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("PatientID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andPatientIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("QuantityUsed"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andQuantityUsedEqualTo",value));
            criteria.when(field.equalsIgnoreCase("LastUpdated"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andLastUpdatedEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Count"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andCountEqualTo",value));
        // 执行查询
        List<Drugconsumption> result =
        (List<Drugconsumption>)
            ReflectionUtils.callIfExists(
                drugconsumptionMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{DrugconsumptionExample.class},
                new Object[]{drugconsumptionExample}
            );
        return result;
    }

}

