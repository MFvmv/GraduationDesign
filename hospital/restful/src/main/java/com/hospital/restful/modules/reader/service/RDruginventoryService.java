package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.Druginventory;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 药品库存管理表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RDruginventoryService {
    List<Druginventory> list(Integer pageSize, Integer pageNum);

    List<Druginventory> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

