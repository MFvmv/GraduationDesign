package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.Drugconsumption;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 药品消耗记录表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RDrugconsumptionService {
    List<Drugconsumption> list(Integer pageSize, Integer pageNum);

    List<Drugconsumption> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

