package com.hospital.restful.modules.contractor.service.impl;
import com.hospital.restful.modules.contractor.domain.CDruginventoryParam;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.contractor.service.CDruginventoryService;
import com.hospital.mbg.mapper.DruginventoryMapper;
import com.hospital.mbg.model.Druginventory;

import org.springframework.beans.BeanUtils;
/**
 * <p>
 * 药品库存管理表 服务实现类
 * 该类依赖于 CDruginventoryParamMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */



@Service
public class CDruginventoryServiceImpl implements  CDruginventoryService {

    @Autowired
    private DruginventoryMapper druginventoryMapper;

    /**
     * 创建新的药品库存管理表的行
     *
     * @param druginventoryParam 创建对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(CDruginventoryParam druginventoryParam) {
        Druginventory druginventory = new Druginventory();
        BeanUtils.copyProperties(druginventoryParam, druginventory);
        //业务逻辑处理(自行编写)
        return druginventoryMapper.insertSelective(druginventory) > 0;
    }

    /**
     * 更新现有的药品库存管理表
     *
     * @param druginventoryParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(CDruginventoryParam druginventoryParam,Integer id) {
        Druginventory druginventory = new Druginventory();
        druginventory.setDrugID(id);
        BeanUtils.copyProperties(druginventoryParam, druginventory);
        //业务逻辑处理(自行编写)
        return druginventoryMapper.updateByPrimaryKeySelective(druginventory) > 0;
    }

    /**
     * 根据ID删除药品库存管理表
     *
     * @param druginventoryId 删除ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer druginventoryId) {
        return druginventoryMapper.deleteByPrimaryKey(druginventoryId) > 0;
    }
}

