package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.Inpatients;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 住院管理表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RInpatientsService {
    List<Inpatients> list(Integer pageSize, Integer pageNum);

    List<Inpatients> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

