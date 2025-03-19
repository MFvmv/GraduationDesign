package com.hospital.restful.modules.reader.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.reader.service.RAppointmentsService;
import com.github.pagehelper.PageHelper;
import com.hospital.mbg.mapper.AppointmentsMapper;
import com.hospital.mbg.model.AppointmentsExample;
import com.hospital.mbg.model.Appointments;
import com.hospital.restful.utils.DynamicCriteriaUtil;
import com.hospital.restful.utils.ReflectionUtils;

import java.util.List;

/**
 * <p>
 * 挂号与预约表 服务实现类
 * 该类依赖于 AppointmentsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-10
 */





@Service
public class RAppointmentsServiceImpl implements  RAppointmentsService {
    @Autowired
    private AppointmentsMapper appointmentsMapper;

    @Override
    public List<Appointments> list(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        AppointmentsExample appointmentsExample = new AppointmentsExample();
        //添加顺序
        appointmentsExample.setOrderByClause("AppointmentDate DESC");
        // 执行查询
        List<Appointments> result =
        (List<Appointments>)
            ReflectionUtils.callIfExists(
                appointmentsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{AppointmentsExample.class},
                new Object[]{appointmentsExample}
            );
        return result;
    }

    @Override
    public List<Appointments> searchByField(String field,Object value,Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        AppointmentsExample appointmentsExample = new AppointmentsExample();
        //添加顺序
        appointmentsExample.setOrderByClause("AppointmentDate DESC");
        // 添加条件
        AppointmentsExample.Criteria criteria = appointmentsExample.createCriteria();
            criteria.when(field.equalsIgnoreCase("AppointmentID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andAppointmentIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("PatientID"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andPatientIDEqualTo",value));
            criteria.when(field.equalsIgnoreCase("AppointmentDate"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andAppointmentDateEqualTo",value));
            criteria.when(field.equalsIgnoreCase("AppointmentTime"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andAppointmentTimeEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Department"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andDepartmentEqualTo",value));
            criteria.when(field.equalsIgnoreCase("DoctorName"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andDoctorNameEqualTo",value));
            criteria.when(field.equalsIgnoreCase("Status"),c -> DynamicCriteriaUtil.invokeAndConvert(c,"andStatusEqualTo",value));
        // 执行查询
        List<Appointments> result =
        (List<Appointments>)
            ReflectionUtils.callIfExists(
                appointmentsMapper,new String[]{
                    "selectByExampleWithBLOBs",
                    "selectByExample"
                    },
                new Class<?>[]{AppointmentsExample.class},
                new Object[]{appointmentsExample}
            );
        return result;
    }

}

