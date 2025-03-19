package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SFinancialrecordsInpatientsRelationService;

import com.hospital.mbg.mapper.FinancialrecordsInpatientsRelationMapper;
import com.hospital.mbg.model.FinancialrecordsInpatientsRelationExample;
import com.hospital.mbg.model.FinancialrecordsInpatientsRelation;

import java.util.List;

/**
 * <p>
 * 财务记录与住院关系表 服务实现类
 * 该类依赖于 FinancialrecordsInpatientsRelationMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SFinancialrecordsInpatientsRelationServiceImpl implements  SFinancialrecordsInpatientsRelationService {

    @Autowired
    private FinancialrecordsInpatientsRelationMapper financialrecordsInpatientsRelationMapper;

    /**
     * 获取所有财务记录与住院关系表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<FinancialrecordsInpatientsRelation> getAll() {
        return financialrecordsInpatientsRelationMapper.selectByExample(new FinancialrecordsInpatientsRelationExample());
    }

    /**
     * 根据ID获取财务记录与住院关系表
     *
     * @param financialrecordsInpatientsRelationId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public FinancialrecordsInpatientsRelation getById(Integer financialrecordsInpatientsRelationId) {
        return financialrecordsInpatientsRelationMapper.selectByPrimaryKey(financialrecordsInpatientsRelationId);
    }

    /**
     * 创建新的财务记录与住院关系表的行
     *
     * @param financialrecordsInpatientsRelation 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(FinancialrecordsInpatientsRelation financialrecordsInpatientsRelation) {
        return financialrecordsInpatientsRelationMapper.insertSelective(financialrecordsInpatientsRelation) > 0;
    }

    /**
     * 更新现有的财务记录与住院关系表
     *
     * @param financialrecordsInpatientsRelation 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(FinancialrecordsInpatientsRelation financialrecordsInpatientsRelation) {
        return financialrecordsInpatientsRelationMapper.updateByPrimaryKeySelective(financialrecordsInpatientsRelation) > 0;
    }

    /**
     * 根据ID删除财务记录与住院关系表
     *
     * @param financialrecordsInpatientsRelationId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer financialrecordsInpatientsRelationId) {
        return financialrecordsInpatientsRelationMapper.deleteByPrimaryKey(financialrecordsInpatientsRelationId) > 0;
    }

}

