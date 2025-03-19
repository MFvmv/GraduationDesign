package com.hospital.restful.modules.standard.service;
import com.hospital.mbg.model.Druginventory;
import java.util.List;



/**
 * <p>
 * 药品库存管理表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-03-14
 */

public interface SDruginventoryService {
    /**
     * 获取所有药品库存管理表
     *
     * @return 包含所有预约的列表
     */
    List<Druginventory> getAll();

    /**
     * 根据ID获取药品库存管理表
     *
     * @param druginventoryId 预约ID
     * @return 对应的预约对象，如果未找到则返回null
     */
    Druginventory getById(Integer druginventoryId);

    /**
     * 创建新的药品库存管理表的行
     *
     * @param druginventory 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(Druginventory druginventory);

    /**
     * 更新现有的药品库存管理表
     *
     * @param druginventory 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(Druginventory druginventory);

    /**
     * 根据ID删除药品库存管理表
     *
     * @param druginventoryId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer druginventoryId);

}

