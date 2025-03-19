package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.Appointments;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 挂号与预约表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RAppointmentsService {
    List<Appointments> list(Integer pageSize, Integer pageNum);

    List<Appointments> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

