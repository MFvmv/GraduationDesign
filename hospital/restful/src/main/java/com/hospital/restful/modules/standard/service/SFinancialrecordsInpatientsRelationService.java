package com.hospital.restful.modules.standard.service;
import com.hospital.mbg.model.FinancialrecordsInpatientsRelation;
import java.util.List;



/**
 * <p>
 * 财务记录与住院关系表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */

public interface SFinancialrecordsInpatientsRelationService {
    /**
     * 获取所有财务记录与住院关系表
     *
     * @return 包含所有预约的列表
     */
    List<FinancialrecordsInpatientsRelation> getAll();

    /**
     * 根据ID获取财务记录与住院关系表
     *
     * @param financialrecordsInpatientsRelationId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    FinancialrecordsInpatientsRelation getById(Integer financialrecordsInpatientsRelationId);

    /**
     * 创建新的财务记录与住院关系表的行
     *
     * @param financialrecordsInpatientsRelation 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(FinancialrecordsInpatientsRelation financialrecordsInpatientsRelation);

    /**
     * 更新现有的财务记录与住院关系表
     *
     * @param financialrecordsInpatientsRelation 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(FinancialrecordsInpatientsRelation financialrecordsInpatientsRelation);

    /**
     * 根据ID删除财务记录与住院关系表
     *
     * @param financialrecordsInpatientsRelationId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer financialrecordsInpatientsRelationId);

}

