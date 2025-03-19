package com.hospital.externalservice.dao;


import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * 前台购物车商品管理自定义Dao
 * Created by macro on 2018/8/2.
 */
public interface FinancialrecordsDao {

    int updatePayStatusToSuccess(@Param("Id") String id);

    int updatePayStatusToFail(@Param("Id") String id);
    /**
     * 根据 id 列表批量更新记录的 OrderNumber 字段
     * @param idList 要更新的记录 id 列表
     * @param orderNumber 要更新的订单号
     * @return 更新成功的记录数
     */
    int updateOrderNumberByIdList(@Param("idList") List<Integer> idList, @Param("orderNumber") String orderNumber);
}
