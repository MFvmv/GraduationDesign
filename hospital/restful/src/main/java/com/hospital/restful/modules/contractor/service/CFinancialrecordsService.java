package com.hospital.restful.modules.contractor.service;

import com.hospital.externalservice.domain.AliPayParam;
import com.hospital.restful.modules.contractor.domain.CFinancialrecordsParam;

/**
 * <p>
 * 财务管理表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */

public interface CFinancialrecordsService {
    /**
     * 创建新的财务管理表的行
     *
     * @param cFinancialrecordsParam 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(CFinancialrecordsParam cFinancialrecordsParam);

    /**
     * 更新现有的财务管理表
     *
     * @param cFinancialrecordsParam 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(CFinancialrecordsParam cFinancialrecordsParam,Integer id);

    /**
     * 根据ID删除财务管理表
     *
     * @param cFinancialrecordsParamId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer cFinancialrecordsParamId);

    boolean processAlipayWebPay(AliPayParam aliPayParam);
}

