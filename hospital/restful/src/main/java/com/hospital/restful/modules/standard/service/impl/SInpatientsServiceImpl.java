package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SInpatientsService;

import com.hospital.mbg.mapper.InpatientsMapper;
import com.hospital.mbg.model.InpatientsExample;
import com.hospital.mbg.model.Inpatients;

import java.util.List;

/**
 * <p>
 * 住院管理表 服务实现类
 * 该类依赖于 InpatientsMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SInpatientsServiceImpl implements  SInpatientsService {

    @Autowired
    private InpatientsMapper inpatientsMapper;

    /**
     * 获取所有住院管理表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<Inpatients> getAll() {
        return inpatientsMapper.selectByExample(new InpatientsExample());
    }

    /**
     * 根据ID获取住院管理表
     *
     * @param inpatientsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public Inpatients getById(Integer inpatientsId) {
        return inpatientsMapper.selectByPrimaryKey(inpatientsId);
    }

    /**
     * 创建新的住院管理表的行
     *
     * @param inpatients 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(Inpatients inpatients) {
        return inpatientsMapper.insertSelective(inpatients) > 0;
    }

    /**
     * 更新现有的住院管理表
     *
     * @param inpatients 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(Inpatients inpatients) {
        return inpatientsMapper.updateByPrimaryKeySelective(inpatients) > 0;
    }

    /**
     * 根据ID删除住院管理表
     *
     * @param inpatientsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer inpatientsId) {
        return inpatientsMapper.deleteByPrimaryKey(inpatientsId) > 0;
    }

}

