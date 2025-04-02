package com.hospital.restful.modules.contractor.service.impl;
import com.hospital.mbg.model.HospitalbedsExample;
import com.hospital.restful.modules.contractor.domain.CHospitalbedsParam;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.contractor.service.CHospitalbedsService;
import com.hospital.mbg.mapper.HospitalbedsMapper;
import com.hospital.mbg.model.Hospitalbeds;

import org.springframework.beans.BeanUtils;
/**
 * <p>
 * 病床管理表 服务实现类
 * 该类依赖于 CHospitalbedsParamMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */



@Service
public class CHospitalbedsServiceImpl implements  CHospitalbedsService {

    @Autowired
    private HospitalbedsMapper hospitalbedsMapper;

    /**
     * 创建新的病床管理表的行
     *
     * @param hospitalbedsParam 创建对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(CHospitalbedsParam hospitalbedsParam) {
        Hospitalbeds hospitalbeds = new Hospitalbeds();
        BeanUtils.copyProperties(hospitalbedsParam, hospitalbeds);
        //业务逻辑处理(自行编写)
        return hospitalbedsMapper.insertSelective(hospitalbeds) > 0;
    }

    @Override
    public boolean hasHospitalbeds(String RoomNumber, Integer BedNumber) {
        HospitalbedsExample example = new HospitalbedsExample();
        HospitalbedsExample.Criteria criteria = example.createCriteria();

        criteria.andRoomNumberEqualTo(RoomNumber);
        criteria.andBedNumberEqualTo(BedNumber);

        long count = hospitalbedsMapper.countByExample(example);

        return count > 0;
    }


    /**
     * 更新现有的病床管理表
     *
     * @param hospitalbedsParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(CHospitalbedsParam hospitalbedsParam,Integer id) {
        Hospitalbeds hospitalbeds = new Hospitalbeds();
        hospitalbeds.setBedID(id);
        BeanUtils.copyProperties(hospitalbedsParam, hospitalbeds);
        //业务逻辑处理(自行编写)
        return hospitalbedsMapper.updateByPrimaryKeySelective(hospitalbeds) > 0;
    }

    /**
     * 根据ID删除病床管理表
     *
     * @param hospitalbedsId 删除ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer hospitalbedsId) {
        return hospitalbedsMapper.deleteByPrimaryKey(hospitalbedsId) > 0;
    }
}

