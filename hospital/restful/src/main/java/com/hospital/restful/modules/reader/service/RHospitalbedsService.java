package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.Hospitalbeds;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 病床管理表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RHospitalbedsService {
    List<Hospitalbeds> list(Integer pageSize, Integer pageNum);

    List<Hospitalbeds> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

