package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.Patients;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 病人信息表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RPatientsService {
    List<Patients> list(Integer pageSize, Integer pageNum);

    List<Patients> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

