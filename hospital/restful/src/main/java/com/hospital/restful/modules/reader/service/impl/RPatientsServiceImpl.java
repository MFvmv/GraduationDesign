package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RPatientsService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.PatientsMapper;
import com.hospital.mbg.model.PatientsExample;
import com.hospital.mbg.model.Patients;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 病人信息表 服务实现类
 * 该类依赖于 PatientsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RPatientsServiceImpl implements  RPatientsService {
    @Autowired
    private PatientsMapper patientsMapper;

    @Override
    public List<Patients> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PatientsExample patientsExample = new PatientsExample();
        //添加顺序
        patientsExample.setOrderByClause("PatientID DESC");
        // 执行查询
        List<Patients> result =
        (List<Patients>)
            ReflectionUtils.callIfExists(
                patientsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{PatientsExample.class},
                new Object[]{patientsExample}
            );
        return result;
    }

    @Override
    public List<Patients> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        PatientsExample patientsExample = new PatientsExample();
        //添加顺序
        patientsExample.setOrderByClause("PatientID DESC");
        // 添加条件
        PatientsExample.Criteria criteria = patientsExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("PatientID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andPatientIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Name"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andNameEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Gender"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andGenderEqualTo",value));
            criteria.when(field.equalsIgnoreCase("DateOfBirth"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andDateOfBirthEqualTo",value));
            criteria.when(field.equalsIgnoreCase("ContactNumber"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andContactNumberEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Address"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andAddressEqualTo",value));
            criteria.when(field.equalsIgnoreCase("EmergencyContact"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andEmergencyContactEqualTo",value));
            criteria.when(field.equalsIgnoreCase("CreatedAt"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andCreatedAtEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Id_card_number"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andId_card_numberEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Id_card_type"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andId_card_typeEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Id_card_expiry"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andId_card_expiryEqualTo",value));
        // 执行查询
        List<Patients> result =
        (List<Patients>)
            ReflectionUtils.callIfExists(
                patientsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{PatientsExample.class},
                new Object[]{patientsExample}
            );
        return result;
    }

}

