package com.hospital.restful.modules.contractor.service;

import com.hospital.restful.modules.contractor.dto.CCDrugconsumptionMixParam;
import com.hospital.restful.modules.contractor.dto.CUDrugconsumptionMixParam;
import com.hospital.restful.modules.contractor.domain.CDrugconsumptionParam;

/**
 * <p>
 * 药品消耗记录表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */

public interface CDrugconsumptionService {
    /**
     * 创建新的药品消耗记录表的行
     *
     * @param cDrugconsumptionParam 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(CDrugconsumptionParam cDrugconsumptionParam);

    /**
     * 创建新的药品消耗记录表的行和财务表的行
     *
     * @param CCDrugconsumptionMixParam 参数对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(CCDrugconsumptionMixParam CCDrugconsumptionMixParam);
    /**
     * 更新现有的药品消耗记录表
     *
     * @param drugconsumptionParam 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(CDrugconsumptionParam drugconsumptionParam, Integer id);
    /**
     * 更新现有的药品消耗记录表和财务关联表
     *
     * @param drugconsumptionMixParam 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(CUDrugconsumptionMixParam drugconsumptionMixParam, Integer id);

    /**
     * 根据ID删除药品消耗记录表
     *
     * @param cDrugconsumptionParamId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer cDrugconsumptionParamId);
}

