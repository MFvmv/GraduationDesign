package com.hospital.restful.modules.standard.service;
import com.hospital.mbg.model.Drugconsumption;
import java.util.List;



/**
 * <p>
 * 药品消耗记录表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */

public interface SDrugconsumptionService {
    /**
     * 获取所有药品消耗记录表
     *
     * @return 包含所有预约的列表
     */
    List<Drugconsumption> getAll();

    /**
     * 根据ID获取药品消耗记录表
     *
     * @param drugconsumptionId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    Drugconsumption getById(Integer drugconsumptionId);

    /**
     * 创建新的药品消耗记录表的行
     *
     * @param drugconsumption 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(Drugconsumption drugconsumption);

    /**
     * 更新现有的药品消耗记录表
     *
     * @param drugconsumption 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(Drugconsumption drugconsumption);

    /**
     * 根据ID删除药品消耗记录表
     *
     * @param drugconsumptionId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer drugconsumptionId);

}

