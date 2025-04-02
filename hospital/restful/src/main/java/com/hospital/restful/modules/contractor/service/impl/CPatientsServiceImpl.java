package com.hospital.restful.modules.contractor.service.impl;
import com.hospital.restful.modules.contractor.domain.CPatientsParam;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.contractor.service.CPatientsService;
import com.hospital.mbg.mapper.PatientsMapper;
import com.hospital.mbg.model.Patients;

import org.springframework.beans.BeanUtils;
/**
 * <p>
 * 病人信息表 服务实现类
 * 该类依赖于 CPatientsParamMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */



@Service
public class CPatientsServiceImpl implements  CPatientsService {

    @Autowired
    private PatientsMapper patientsMapper;

    /**
     * 创建新的病人信息表的行
     *
     * @param patientsParam 创建对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(CPatientsParam patientsParam) {
        Patients patients = new Patients();
        BeanUtils.copyProperties(patientsParam, patients);
        //业务逻辑处理(自行编写)
        return patientsMapper.insertSelective(patients) > 0;
    }

    /**
     * 更新现有的病人信息表
     *
     * @param patientsParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(CPatientsParam patientsParam,Integer id) {
        Patients patients = new Patients();
        patients.setPatientID(id);
        BeanUtils.copyProperties(patientsParam, patients);
        //业务逻辑处理(自行编写)
        return patientsMapper.updateByPrimaryKeySelective(patients) > 0;
    }

    /**
     * 根据ID删除病人信息表
     *
     * @param patientsId 删除ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer patientsId) {
        return patientsMapper.deleteByPrimaryKey(patientsId) > 0;
    }
}

