package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RMedicalrecordsService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.MedicalrecordsMapper;
import com.hospital.mbg.model.MedicalrecordsExample;
import com.hospital.mbg.model.Medicalrecords;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 病历管理表 服务实现类
 * 该类依赖于 MedicalrecordsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RMedicalrecordsServiceImpl implements  RMedicalrecordsService {
    @Autowired
    private MedicalrecordsMapper medicalrecordsMapper;

    @Override
    public List<Medicalrecords> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        MedicalrecordsExample medicalrecordsExample = new MedicalrecordsExample();
        //添加顺序
        medicalrecordsExample.setOrderByClause("RecordDate DESC");
        // 执行查询
        List<Medicalrecords> result =
        (List<Medicalrecords>)
            ReflectionUtils.callIfExists(
                medicalrecordsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{MedicalrecordsExample.class},
                new Object[]{medicalrecordsExample}
            );
        return result;
    }

    @Override
    public List<Medicalrecords> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        MedicalrecordsExample medicalrecordsExample = new MedicalrecordsExample();
        //添加顺序
        medicalrecordsExample.setOrderByClause("RecordDate DESC");
        // 添加条件
        MedicalrecordsExample.Criteria criteria = medicalrecordsExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("RecordID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andRecordIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("PatientID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andPatientIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Diagnosis"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andDiagnosisEqualTo",value));
            criteria.when(field.equalsIgnoreCase("TreatmentPlan"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andTreatmentPlanEqualTo",value));
            criteria.when(field.equalsIgnoreCase("TestReports"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andTestReportsEqualTo",value));
            criteria.when(field.equalsIgnoreCase("RecordDate"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andRecordDateEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Image_data"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andImage_dataEqualTo",value));
        // 执行查询
        List<Medicalrecords> result =
        (List<Medicalrecords>)
            ReflectionUtils.callIfExists(
                medicalrecordsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{MedicalrecordsExample.class},
                new Object[]{medicalrecordsExample}
            );
        return result;
    }

}

