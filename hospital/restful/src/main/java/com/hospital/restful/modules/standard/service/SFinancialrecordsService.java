package com.hospital.restful.modules.standard.service;
import com.hospital.mbg.model.Financialrecords;
import java.util.List;



/**
 * <p>
 * 财务管理表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */

public interface SFinancialrecordsService {
    /**
     * 获取所有财务管理表
     *
     * @return 包含所有预约的列表
     */
    List<Financialrecords> getAll();

    /**
     * 根据ID获取财务管理表
     *
     * @param financialrecordsId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    Financialrecords getById(Integer financialrecordsId);

    /**
     * 创建新的财务管理表的行
     *
     * @param financialrecords 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(Financialrecords financialrecords);

    /**
     * 更新现有的财务管理表
     *
     * @param financialrecords 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(Financialrecords financialrecords);

    /**
     * 根据ID删除财务管理表
     *
     * @param financialrecordsId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer financialrecordsId);

}

