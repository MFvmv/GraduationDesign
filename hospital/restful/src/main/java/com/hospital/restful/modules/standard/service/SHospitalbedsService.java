package com.hospital.restful.modules.standard.service;
import com.hospital.mbg.model.Hospitalbeds;
import java.util.List;



/**
 * <p>
 * 病床管理表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */

public interface SHospitalbedsService {
    /**
     * 获取所有病床管理表
     *
     * @return 包含所有预约的列表
     */
    List<Hospitalbeds> getAll();

    /**
     * 根据ID获取病床管理表
     *
     * @param hospitalbedsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    Hospitalbeds getById(Integer hospitalbedsId);

    /**
     * 创建新的病床管理表的行
     *
     * @param hospitalbeds 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(Hospitalbeds hospitalbeds);

    /**
     * 更新现有的病床管理表
     *
     * @param hospitalbeds 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(Hospitalbeds hospitalbeds);

    /**
     * 根据ID删除病床管理表
     *
     * @param hospitalbedsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer hospitalbedsId);

}

