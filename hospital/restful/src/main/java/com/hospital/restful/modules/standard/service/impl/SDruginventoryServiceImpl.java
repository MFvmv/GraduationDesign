package com.hospital.restful.modules.standard.service.impl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.standard.service.SDruginventoryService;

import com.hospital.mbg.mapper.DruginventoryMapper;
import com.hospital.mbg.model.DruginventoryExample;
import com.hospital.mbg.model.Druginventory;

import java.util.List;

/**
 * <p>
 * 药品库存管理表 服务实现类
 * 该类依赖于 DruginventoryMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */



@Service
public class SDruginventoryServiceImpl implements  SDruginventoryService {

    @Autowired
    private DruginventoryMapper druginventoryMapper;

    /**
     * 获取所有药品库存管理表
     *
     * @return 包含所有预约的列表
     */
    @Override
    public List<Druginventory> getAll() {
        return druginventoryMapper.selectByExample(new DruginventoryExample());
    }

    /**
     * 根据ID获取药品库存管理表
     *
     * @param druginventoryId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    @Override
    public Druginventory getById(Integer druginventoryId) {
        return druginventoryMapper.selectByPrimaryKey(druginventoryId);
    }

    /**
     * 创建新的药品库存管理表的行
     *
     * @param druginventory 预约对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(Druginventory druginventory) {
        return druginventoryMapper.insertSelective(druginventory) > 0;
    }

    /**
     * 更新现有的药品库存管理表
     *
     * @param druginventory 预约对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(Druginventory druginventory) {
        return druginventoryMapper.updateByPrimaryKeySelective(druginventory) > 0;
    }

    /**
     * 根据ID删除药品库存管理表
     *
     * @param druginventoryId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer druginventoryId) {
        return druginventoryMapper.deleteByPrimaryKey(druginventoryId) > 0;
    }

}

