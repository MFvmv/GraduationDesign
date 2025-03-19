package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RDruginventoryService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.DruginventoryMapper;
import com.hospital.mbg.model.DruginventoryExample;
import com.hospital.mbg.model.Druginventory;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 药品库存管理表 服务实现类
 * 该类依赖于 DruginventoryMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RDruginventoryServiceImpl implements  RDruginventoryService {
    @Autowired
    private DruginventoryMapper druginventoryMapper;

    @Override
    public List<Druginventory> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        DruginventoryExample druginventoryExample = new DruginventoryExample();
        //添加顺序
        druginventoryExample.setOrderByClause("LastUpdated DESC");
        // 执行查询
        List<Druginventory> result =
        (List<Druginventory>)
            ReflectionUtils.callIfExists(
                druginventoryMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{DruginventoryExample.class},
                new Object[]{druginventoryExample}
            );
        return result;
    }

    @Override
    public List<Druginventory> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        DruginventoryExample druginventoryExample = new DruginventoryExample();
        //添加顺序
        druginventoryExample.setOrderByClause("LastUpdated DESC");
        // 添加条件
        DruginventoryExample.Criteria criteria = druginventoryExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("DrugID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andDrugIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("DrugName"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andDrugNameEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Category"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andCategoryEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Quantity"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andQuantityEqualTo",value));
            criteria.when(field.equalsIgnoreCase("UnitPrice"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andUnitPriceEqualTo",value));
            criteria.when(field.equalsIgnoreCase("SupplierName"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andSupplierNameEqualTo",value));
            criteria.when(field.equalsIgnoreCase("LastUpdated"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andLastUpdatedEqualTo",value));
            criteria.when(field.equalsIgnoreCase("ManufactureDate"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andManufactureDateEqualTo",value));
            criteria.when(field.equalsIgnoreCase("ExpiryDate"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andExpiryDateEqualTo",value));
        // 执行查询
        List<Druginventory> result =
        (List<Druginventory>)
            ReflectionUtils.callIfExists(
                druginventoryMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{DruginventoryExample.class},
                new Object[]{druginventoryExample}
            );
        return result;
    }

}

