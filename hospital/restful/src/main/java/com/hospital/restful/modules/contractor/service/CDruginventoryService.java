package com.hospital.restful.modules.contractor.service;

import com.hospital.restful.modules.contractor.domain.CDruginventoryParam;

/**
 * <p>
 * 药品库存管理表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */

public interface CDruginventoryService {
    /**
     * 创建新的药品库存管理表的行
     *
     * @param cDruginventoryParam 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(CDruginventoryParam cDruginventoryParam);

    /**
     * 更新现有的药品库存管理表
     *
     * @param cDruginventoryParam 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(CDruginventoryParam cDruginventoryParam,Integer id);

    /**
     * 根据ID删除药品库存管理表
     *
     * @param cDruginventoryParamId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer cDruginventoryParamId);
}

