package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SPatientsService;

import com.hospital.mbg.mapper.PatientsMapper;
import com.hospital.mbg.model.PatientsExample;
import com.hospital.mbg.model.Patients;

import java.util.List;

/**
 * <p>
 * 病人信息表 服务实现类
 * 该类依赖于 PatientsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SPatientsServiceImpl implements  SPatientsService {

    @Autowired
    private PatientsMapper patientsMapper;

    /**
     * 获取所有病人信息表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<Patients> getAll() {
        return patientsMapper.selectByExample(new PatientsExample());
    }

    /**
     * 根据ID获取病人信息表
     *
     * @param patientsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public Patients getById(Integer patientsId) {
        return patientsMapper.selectByPrimaryKey(patientsId);
    }

    /**
     * 创建新的病人信息表的行
     *
     * @param patients 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(Patients patients) {
        return patientsMapper.insertSelective(patients) > 0;
    }

    /**
     * 更新现有的病人信息表
     *
     * @param patients 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(Patients patients) {
        return patientsMapper.updateByPrimaryKeySelective(patients) > 0;
    }

    /**
     * 根据ID删除病人信息表
     *
     * @param patientsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer patientsId) {
        return patientsMapper.deleteByPrimaryKey(patientsId) > 0;
    }

}

