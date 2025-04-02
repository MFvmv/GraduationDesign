package com.hospital.restful.modules.contractor.service.impl;
import com.hospital.restful.modules.contractor.domain.CAppointmentsParam;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.contractor.service.CAppointmentsService;
import com.hospital.mbg.mapper.AppointmentsMapper;
import com.hospital.mbg.model.Appointments;

import org.springframework.beans.BeanUtils;
/**
 * <p>
 * 挂号与预约表 服务实现类
 * 该类依赖于 CAppointmentsParamMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */



@Service
public class CAppointmentsServiceImpl implements  CAppointmentsService {

    @Autowired
    private AppointmentsMapper appointmentsMapper;

    /**
     * 创建新的挂号与预约表的行
     *
     * @param appointmentsParam 创建对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(CAppointmentsParam appointmentsParam) {
        Appointments appointments = new Appointments();
        BeanUtils.copyProperties(appointmentsParam, appointments);
        //业务逻辑处理(自行编写)
        return appointmentsMapper.insertSelective(appointments) > 0;
    }

    /**
     * 更新现有的挂号与预约表
     *
     * @param appointmentsParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(CAppointmentsParam appointmentsParam,Integer id) {
        Appointments appointments = new Appointments();
        appointments.setAppointmentID(id);
        BeanUtils.copyProperties(appointmentsParam, appointments);
        //业务逻辑处理(自行编写)
        return appointmentsMapper.updateByPrimaryKeySelective(appointments) > 0;
    }

    /**
     * 根据ID删除挂号与预约表
     *
     * @param appointmentsId 删除ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer appointmentsId) {
        return appointmentsMapper.deleteByPrimaryKey(appointmentsId) > 0;
    }
}

