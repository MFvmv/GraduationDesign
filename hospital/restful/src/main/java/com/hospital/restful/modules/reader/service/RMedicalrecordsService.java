package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.Medicalrecords;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 病历管理表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RMedicalrecordsService {
    List<Medicalrecords> list(Integer pageSize, Integer pageNum);

    List<Medicalrecords> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

