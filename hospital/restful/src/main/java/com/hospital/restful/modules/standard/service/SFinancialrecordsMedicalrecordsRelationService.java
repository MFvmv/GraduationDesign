package com.hospital.restful.modules.standard.service;
import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelation;
import java.util.List;



/**
 * <p>
 * 财务记录与病历关系表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */

public interface SFinancialrecordsMedicalrecordsRelationService {
    /**
     * 获取所有财务记录与病历关系表
     *
     * @return 包含所有预约的列表
     */
    List<FinancialrecordsMedicalrecordsRelation> getAll();

    /**
     * 根据ID获取财务记录与病历关系表
     *
     * @param financialrecordsMedicalrecordsRelationId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    FinancialrecordsMedicalrecordsRelation getById(Integer financialrecordsMedicalrecordsRelationId);

    /**
     * 创建新的财务记录与病历关系表的行
     *
     * @param financialrecordsMedicalrecordsRelation 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(FinancialrecordsMedicalrecordsRelation financialrecordsMedicalrecordsRelation);

    /**
     * 更新现有的财务记录与病历关系表
     *
     * @param financialrecordsMedicalrecordsRelation 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(FinancialrecordsMedicalrecordsRelation financialrecordsMedicalrecordsRelation);

    /**
     * 根据ID删除财务记录与病历关系表
     *
     * @param financialrecordsMedicalrecordsRelationId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer financialrecordsMedicalrecordsRelationId);

}

