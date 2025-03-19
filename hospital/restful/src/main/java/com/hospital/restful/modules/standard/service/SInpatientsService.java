package com.hospital.restful.modules.standard.service;
import com.hospital.mbg.model.Inpatients;
import java.util.List;



/**
 * <p>
 * 住院管理表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */

public interface SInpatientsService {
    /**
     * 获取所有住院管理表
     *
     * @return 包含所有预约的列表
     */
    List<Inpatients> getAll();

    /**
     * 根据ID获取住院管理表
     *
     * @param inpatientsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    Inpatients getById(Integer inpatientsId);

    /**
     * 创建新的住院管理表的行
     *
     * @param inpatients 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(Inpatients inpatients);

    /**
     * 更新现有的住院管理表
     *
     * @param inpatients 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(Inpatients inpatients);

    /**
     * 根据ID删除住院管理表
     *
     * @param inpatientsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer inpatientsId);

}

