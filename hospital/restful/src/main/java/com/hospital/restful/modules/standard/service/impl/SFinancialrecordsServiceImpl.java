package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SFinancialrecordsService;

import com.hospital.mbg.mapper.FinancialrecordsMapper;
import com.hospital.mbg.model.FinancialrecordsExample;
import com.hospital.mbg.model.Financialrecords;

import java.util.List;

/**
 * <p>
 * 财务管理表 服务实现类
 * 该类依赖于 FinancialrecordsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SFinancialrecordsServiceImpl implements  SFinancialrecordsService {

    @Autowired
    private FinancialrecordsMapper financialrecordsMapper;

    /**
     * 获取所有财务管理表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<Financialrecords> getAll() {
        return financialrecordsMapper.selectByExample(new FinancialrecordsExample());
    }

    /**
     * 根据ID获取财务管理表
     *
     * @param financialrecordsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public Financialrecords getById(Integer financialrecordsId) {
        return financialrecordsMapper.selectByPrimaryKey(financialrecordsId);
    }

    /**
     * 创建新的财务管理表的行
     *
     * @param financialrecords 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(Financialrecords financialrecords) {
        return financialrecordsMapper.insertSelective(financialrecords) > 0;
    }

    /**
     * 更新现有的财务管理表
     *
     * @param financialrecords 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(Financialrecords financialrecords) {
        return financialrecordsMapper.updateByPrimaryKeySelective(financialrecords) > 0;
    }

    /**
     * 根据ID删除财务管理表
     *
     * @param financialrecordsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer financialrecordsId) {
        return financialrecordsMapper.deleteByPrimaryKey(financialrecordsId) > 0;
    }

}

