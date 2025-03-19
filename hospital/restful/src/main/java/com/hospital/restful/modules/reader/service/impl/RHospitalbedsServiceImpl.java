package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RHospitalbedsService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.HospitalbedsMapper;
import com.hospital.mbg.model.HospitalbedsExample;
import com.hospital.mbg.model.Hospitalbeds;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 病床管理表 服务实现类
 * 该类依赖于 HospitalbedsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RHospitalbedsServiceImpl implements  RHospitalbedsService {
    @Autowired
    private HospitalbedsMapper hospitalbedsMapper;

    @Override
    public List<Hospitalbeds> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        HospitalbedsExample hospitalbedsExample = new HospitalbedsExample();
        //添加顺序
        // 执行查询
        List<Hospitalbeds> result =
        (List<Hospitalbeds>)
            ReflectionUtils.callIfExists(
                hospitalbedsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{HospitalbedsExample.class},
                new Object[]{hospitalbedsExample}
            );
        return result;
    }

    @Override
    public List<Hospitalbeds> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        HospitalbedsExample hospitalbedsExample = new HospitalbedsExample();
        //添加顺序
        // 添加条件
        HospitalbedsExample.Criteria criteria = hospitalbedsExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("BedID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andBedIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("RoomNumber"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andRoomNumberEqualTo",value));
            criteria.when(field.equalsIgnoreCase("BedNumber"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andBedNumberEqualTo",value));
            criteria.when(field.equalsIgnoreCase("BedStatus"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andBedStatusEqualTo",value));
            criteria.when(field.equalsIgnoreCase("PatientID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andPatientIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("LastUpdated"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andLastUpdatedEqualTo",value));
        // 执行查询
        List<Hospitalbeds> result =
        (List<Hospitalbeds>)
            ReflectionUtils.callIfExists(
                hospitalbedsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{HospitalbedsExample.class},
                new Object[]{hospitalbedsExample}
            );
        return result;
    }

}

