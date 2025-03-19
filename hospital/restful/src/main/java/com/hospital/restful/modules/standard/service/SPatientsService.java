package com.hospital.restful.modules.standard.service;
import com.hospital.mbg.model.Patients;
import java.util.List;



/**
 * <p>
 * 病人信息表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */

public interface SPatientsService {
    /**
     * 获取所有病人信息表
     *
     * @return 包含所有预约的列表
     */
    List<Patients> getAll();

    /**
     * 根据ID获取病人信息表
     *
     * @param patientsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    Patients getById(Integer patientsId);

    /**
     * 创建新的病人信息表的行
     *
     * @param patients 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(Patients patients);

    /**
     * 更新现有的病人信息表
     *
     * @param patients 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(Patients patients);

    /**
     * 根据ID删除病人信息表
     *
     * @param patientsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer patientsId);

}

