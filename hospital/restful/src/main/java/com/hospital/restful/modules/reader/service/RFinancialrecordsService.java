package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.Financialrecords;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 财务管理表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RFinancialrecordsService {
    List<Financialrecords> list(Integer pageSize, Integer pageNum);

    List<Financialrecords> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

