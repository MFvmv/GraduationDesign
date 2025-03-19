package com.hospital.restful.modules.standard.service;
import com.hospital.mbg.model.Medicalrecords;
import java.util.List;



/**
 * <p>
 * 病历管理表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */

public interface SMedicalrecordsService {
    /**
     * 获取所有病历管理表
     *
     * @return 包含所有预约的列表
     */
    List<Medicalrecords> getAll();

    /**
     * 根据ID获取病历管理表
     *
     * @param medicalrecordsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    Medicalrecords getById(Integer medicalrecordsId);

    /**
     * 创建新的病历管理表的行
     *
     * @param medicalrecords 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(Medicalrecords medicalrecords);

    /**
     * 更新现有的病历管理表
     *
     * @param medicalrecords 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(Medicalrecords medicalrecords);

    /**
     * 根据ID删除病历管理表
     *
     * @param medicalrecordsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer medicalrecordsId);

}

