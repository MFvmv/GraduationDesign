package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SFinancialrecordsMedicalrecordsRelationService;

import com.hospital.mbg.mapper.FinancialrecordsMedicalrecordsRelationMapper;
import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelationExample;
import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelation;

import java.util.List;

/**
 * <p>
 * 财务记录与病历关系表 服务实现类
 * 该类依赖于 FinancialrecordsMedicalrecordsRelationMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SFinancialrecordsMedicalrecordsRelationServiceImpl implements  SFinancialrecordsMedicalrecordsRelationService {

    @Autowired
    private FinancialrecordsMedicalrecordsRelationMapper financialrecordsMedicalrecordsRelationMapper;

    /**
     * 获取所有财务记录与病历关系表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<FinancialrecordsMedicalrecordsRelation> getAll() {
        return financialrecordsMedicalrecordsRelationMapper.selectByExample(new FinancialrecordsMedicalrecordsRelationExample());
    }

    /**
     * 根据ID获取财务记录与病历关系表
     *
     * @param financialrecordsMedicalrecordsRelationId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public FinancialrecordsMedicalrecordsRelation getById(Integer financialrecordsMedicalrecordsRelationId) {
        return financialrecordsMedicalrecordsRelationMapper.selectByPrimaryKey(financialrecordsMedicalrecordsRelationId);
    }

    /**
     * 创建新的财务记录与病历关系表的行
     *
     * @param financialrecordsMedicalrecordsRelation 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(FinancialrecordsMedicalrecordsRelation financialrecordsMedicalrecordsRelation) {
        return financialrecordsMedicalrecordsRelationMapper.insertSelective(financialrecordsMedicalrecordsRelation) > 0;
    }

    /**
     * 更新现有的财务记录与病历关系表
     *
     * @param financialrecordsMedicalrecordsRelation 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(FinancialrecordsMedicalrecordsRelation financialrecordsMedicalrecordsRelation) {
        return financialrecordsMedicalrecordsRelationMapper.updateByPrimaryKeySelective(financialrecordsMedicalrecordsRelation) > 0;
    }

    /**
     * 根据ID删除财务记录与病历关系表
     *
     * @param financialrecordsMedicalrecordsRelationId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer financialrecordsMedicalrecordsRelationId) {
        return financialrecordsMedicalrecordsRelationMapper.deleteByPrimaryKey(financialrecordsMedicalrecordsRelationId) > 0;
    }

}

