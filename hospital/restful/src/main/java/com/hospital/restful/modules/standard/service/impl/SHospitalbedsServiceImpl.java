package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SHospitalbedsService;

import com.hospital.mbg.mapper.HospitalbedsMapper;
import com.hospital.mbg.model.HospitalbedsExample;
import com.hospital.mbg.model.Hospitalbeds;

import java.util.List;

/**
 * <p>
 * 病床管理表 服务实现类
 * 该类依赖于 HospitalbedsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SHospitalbedsServiceImpl implements  SHospitalbedsService {

    @Autowired
    private HospitalbedsMapper hospitalbedsMapper;

    /**
     * 获取所有病床管理表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<Hospitalbeds> getAll() {
        return hospitalbedsMapper.selectByExample(new HospitalbedsExample());
    }

    /**
     * 根据ID获取病床管理表
     *
     * @param hospitalbedsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public Hospitalbeds getById(Integer hospitalbedsId) {
        return hospitalbedsMapper.selectByPrimaryKey(hospitalbedsId);
    }

    /**
     * 创建新的病床管理表的行
     *
     * @param hospitalbeds 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(Hospitalbeds hospitalbeds) {
        return hospitalbedsMapper.insertSelective(hospitalbeds) > 0;
    }

    /**
     * 更新现有的病床管理表
     *
     * @param hospitalbeds 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(Hospitalbeds hospitalbeds) {
        return hospitalbedsMapper.updateByPrimaryKeySelective(hospitalbeds) > 0;
    }

    /**
     * 根据ID删除病床管理表
     *
     * @param hospitalbedsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer hospitalbedsId) {
        return hospitalbedsMapper.deleteByPrimaryKey(hospitalbedsId) > 0;
    }

}

