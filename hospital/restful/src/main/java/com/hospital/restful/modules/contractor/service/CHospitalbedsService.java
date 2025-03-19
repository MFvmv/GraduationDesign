package com.hospital.restful.modules.contractor.service;

import com.hospital.restful.modules.contractor.dto.CHospitalbedsParam;

/**
 * <p>
 * 病床管理表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */

public interface CHospitalbedsService {
    /**
     * 创建新的病床管理表的行
     *
     * @param cHospitalbedsParam 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(CHospitalbedsParam cHospitalbedsParam);

    /**
     * 更新现有的病床管理表
     *
     * @param cHospitalbedsParam 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(CHospitalbedsParam cHospitalbedsParam,Integer id);

    /**
     * 根据ID删除病床管理表
     *
     * @param cHospitalbedsParamId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer cHospitalbedsParamId);

    boolean hasHospitalbeds(String RoomNumber, Integer BedNumber);
}

