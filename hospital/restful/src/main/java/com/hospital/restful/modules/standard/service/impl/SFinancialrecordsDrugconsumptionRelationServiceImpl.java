package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SFinancialrecordsDrugconsumptionRelationService;

import com.hospital.mbg.mapper.FinancialrecordsDrugconsumptionRelationMapper;
import com.hospital.mbg.model.FinancialrecordsDrugconsumptionRelationExample;
import com.hospital.mbg.model.FinancialrecordsDrugconsumptionRelation;

import java.util.List;

/**
 * <p>
 * 财务记录与药品消耗关系表 服务实现类
 * 该类依赖于 FinancialrecordsDrugconsumptionRelationMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SFinancialrecordsDrugconsumptionRelationServiceImpl implements  SFinancialrecordsDrugconsumptionRelationService {

    @Autowired
    private FinancialrecordsDrugconsumptionRelationMapper financialrecordsDrugconsumptionRelationMapper;

    /**
     * 获取所有财务记录与药品消耗关系表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<FinancialrecordsDrugconsumptionRelation> getAll() {
        return financialrecordsDrugconsumptionRelationMapper.selectByExample(new FinancialrecordsDrugconsumptionRelationExample());
    }

    /**
     * 根据ID获取财务记录与药品消耗关系表
     *
     * @param financialrecordsDrugconsumptionRelationId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public FinancialrecordsDrugconsumptionRelation getById(Integer financialrecordsDrugconsumptionRelationId) {
        return financialrecordsDrugconsumptionRelationMapper.selectByPrimaryKey(financialrecordsDrugconsumptionRelationId);
    }

    /**
     * 创建新的财务记录与药品消耗关系表的行
     *
     * @param financialrecordsDrugconsumptionRelation 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(FinancialrecordsDrugconsumptionRelation financialrecordsDrugconsumptionRelation) {
        return financialrecordsDrugconsumptionRelationMapper.insertSelective(financialrecordsDrugconsumptionRelation) > 0;
    }

    /**
     * 更新现有的财务记录与药品消耗关系表
     *
     * @param financialrecordsDrugconsumptionRelation 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(FinancialrecordsDrugconsumptionRelation financialrecordsDrugconsumptionRelation) {
        return financialrecordsDrugconsumptionRelationMapper.updateByPrimaryKeySelective(financialrecordsDrugconsumptionRelation) > 0;
    }

    /**
     * 根据ID删除财务记录与药品消耗关系表
     *
     * @param financialrecordsDrugconsumptionRelationId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer financialrecordsDrugconsumptionRelationId) {
        return financialrecordsDrugconsumptionRelationMapper.deleteByPrimaryKey(financialrecordsDrugconsumptionRelationId) > 0;
    }

}

