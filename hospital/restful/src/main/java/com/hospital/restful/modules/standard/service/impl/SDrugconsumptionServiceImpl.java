package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SDrugconsumptionService;

import com.hospital.mbg.mapper.DrugconsumptionMapper;
import com.hospital.mbg.model.DrugconsumptionExample;
import com.hospital.mbg.model.Drugconsumption;

import java.util.List;

/**
 * <p>
 * 药品消耗记录表 服务实现类
 * 该类依赖于 DrugconsumptionMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SDrugconsumptionServiceImpl implements  SDrugconsumptionService {

    @Autowired
    private DrugconsumptionMapper drugconsumptionMapper;

    /**
     * 获取所有药品消耗记录表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<Drugconsumption> getAll() {
        return drugconsumptionMapper.selectByExample(new DrugconsumptionExample());
    }

    /**
     * 根据ID获取药品消耗记录表
     *
     * @param drugconsumptionId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public Drugconsumption getById(Integer drugconsumptionId) {
        return drugconsumptionMapper.selectByPrimaryKey(drugconsumptionId);
    }

    /**
     * 创建新的药品消耗记录表的行
     *
     * @param drugconsumption 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(Drugconsumption drugconsumption) {
        return drugconsumptionMapper.insertSelective(drugconsumption) > 0;
    }

    /**
     * 更新现有的药品消耗记录表
     *
     * @param drugconsumption 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(Drugconsumption drugconsumption) {
        return drugconsumptionMapper.updateByPrimaryKeySelective(drugconsumption) > 0;
    }

    /**
     * 根据ID删除药品消耗记录表
     *
     * @param drugconsumptionId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer drugconsumptionId) {
        return drugconsumptionMapper.deleteByPrimaryKey(drugconsumptionId) > 0;
    }

}

