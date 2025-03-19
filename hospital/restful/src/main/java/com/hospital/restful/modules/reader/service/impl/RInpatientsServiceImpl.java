package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RInpatientsService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.InpatientsMapper;
import com.hospital.mbg.model.InpatientsExample;
import com.hospital.mbg.model.Inpatients;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 住院管理表 服务实现类
 * 该类依赖于 InpatientsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RInpatientsServiceImpl implements  RInpatientsService {
    @Autowired
    private InpatientsMapper inpatientsMapper;

    @Override
    public List<Inpatients> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        InpatientsExample inpatientsExample = new InpatientsExample();
        //添加顺序
        inpatientsExample.setOrderByClause("AdmissionDate DESC");
        // 执行查询
        List<Inpatients> result =
        (List<Inpatients>)
            ReflectionUtils.callIfExists(
                inpatientsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{InpatientsExample.class},
                new Object[]{inpatientsExample}
            );
        return result;
    }

    @Override
    public List<Inpatients> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        InpatientsExample inpatientsExample = new InpatientsExample();
        //添加顺序
        inpatientsExample.setOrderByClause("AdmissionDate DESC");
        // 添加条件
        InpatientsExample.Criteria criteria = inpatientsExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("InpatientID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andInpatientIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("PatientID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andPatientIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("AdmissionDate"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andAdmissionDateEqualTo",value));
            criteria.when(field.equalsIgnoreCase("DischargeDate"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andDischargeDateEqualTo",value));
            criteria.when(field.equalsIgnoreCase("RoomNumber"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andRoomNumberEqualTo",value));
            criteria.when(field.equalsIgnoreCase("BedNumber"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andBedNumberEqualTo",value));
            criteria.when(field.equalsIgnoreCase("CurrentStatus"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andCurrentStatusEqualTo",value));
        // 执行查询
        List<Inpatients> result =
        (List<Inpatients>)
            ReflectionUtils.callIfExists(
                inpatientsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{InpatientsExample.class},
                new Object[]{inpatientsExample}
            );
        return result;
    }

}

