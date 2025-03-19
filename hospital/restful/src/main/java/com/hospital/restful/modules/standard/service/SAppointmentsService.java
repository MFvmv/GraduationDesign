package com.hospital.restful.modules.standard.service;
import com.hospital.mbg.model.Appointments;
import java.util.List;



/**
 * <p>
 * 挂号与预约表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */

public interface SAppointmentsService {
    /**
     * 获取所有挂号与预约表
     *
     * @return 包含所有预约的列表
     */
    List<Appointments> getAll();

    /**
     * 根据ID获取挂号与预约表
     *
     * @param appointmentsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    Appointments getById(Integer appointmentsId);

    /**
     * 创建新的挂号与预约表的行
     *
     * @param appointments 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(Appointments appointments);

    /**
     * 更新现有的挂号与预约表
     *
     * @param appointments 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(Appointments appointments);

    /**
     * 根据ID删除挂号与预约表
     *
     * @param appointmentsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer appointmentsId);

}

