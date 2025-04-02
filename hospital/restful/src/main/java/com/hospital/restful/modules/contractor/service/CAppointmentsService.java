package com.hospital.restful.modules.contractor.service;

import com.hospital.restful.modules.contractor.domain.CAppointmentsParam;

/**
 * <p>
 * 挂号与预约表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */

public interface CAppointmentsService {
    /**
     * 创建新的挂号与预约表的行
     *
     * @param cAppointmentsParam 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(CAppointmentsParam cAppointmentsParam);

    /**
     * 更新现有的挂号与预约表
     *
     * @param cAppointmentsParam 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(CAppointmentsParam cAppointmentsParam,Integer id);

    /**
     * 根据ID删除挂号与预约表
     *
     * @param cAppointmentsParamId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer cAppointmentsParamId);
}

