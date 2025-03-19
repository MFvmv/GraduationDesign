package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SAppointmentsService;

import com.hospital.mbg.mapper.AppointmentsMapper;
import com.hospital.mbg.model.AppointmentsExample;
import com.hospital.mbg.model.Appointments;

import java.util.List;

/**
 * <p>
 * 挂号与预约表 服务实现类
 * 该类依赖于 AppointmentsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SAppointmentsServiceImpl implements  SAppointmentsService {

    @Autowired
    private AppointmentsMapper appointmentsMapper;

    /**
     * 获取所有挂号与预约表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<Appointments> getAll() {
        return appointmentsMapper.selectByExample(new AppointmentsExample());
    }

    /**
     * 根据ID获取挂号与预约表
     *
     * @param appointmentsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public Appointments getById(Integer appointmentsId) {
        return appointmentsMapper.selectByPrimaryKey(appointmentsId);
    }

    /**
     * 创建新的挂号与预约表的行
     *
     * @param appointments 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(Appointments appointments) {
        return appointmentsMapper.insertSelective(appointments) > 0;
    }

    /**
     * 更新现有的挂号与预约表
     *
     * @param appointments 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(Appointments appointments) {
        return appointmentsMapper.updateByPrimaryKeySelective(appointments) > 0;
    }

    /**
     * 根据ID删除挂号与预约表
     *
     * @param appointmentsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer appointmentsId) {
        return appointmentsMapper.deleteByPrimaryKey(appointmentsId) > 0;
    }

}

