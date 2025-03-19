package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SMedicalrecordsService;

import com.hospital.mbg.mapper.MedicalrecordsMapper;
import com.hospital.mbg.model.MedicalrecordsExample;
import com.hospital.mbg.model.Medicalrecords;

import java.util.List;

/**
 * <p>
 * 病历管理表 服务实现类
 * 该类依赖于 MedicalrecordsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SMedicalrecordsServiceImpl implements  SMedicalrecordsService {

    @Autowired
    private MedicalrecordsMapper medicalrecordsMapper;

    /**
     * 获取所有病历管理表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<Medicalrecords> getAll() {
        return medicalrecordsMapper.selectByExample(new MedicalrecordsExample());
    }

    /**
     * 根据ID获取病历管理表
     *
     * @param medicalrecordsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public Medicalrecords getById(Integer medicalrecordsId) {
        return medicalrecordsMapper.selectByPrimaryKey(medicalrecordsId);
    }

    /**
     * 创建新的病历管理表的行
     *
     * @param medicalrecords 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(Medicalrecords medicalrecords) {
        return medicalrecordsMapper.insertSelective(medicalrecords) > 0;
    }

    /**
     * 更新现有的病历管理表
     *
     * @param medicalrecords 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(Medicalrecords medicalrecords) {
        return medicalrecordsMapper.updateByPrimaryKeySelective(medicalrecords) > 0;
    }

    /**
     * 根据ID删除病历管理表
     *
     * @param medicalrecordsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer medicalrecordsId) {
        return medicalrecordsMapper.deleteByPrimaryKey(medicalrecordsId) > 0;
    }

}

