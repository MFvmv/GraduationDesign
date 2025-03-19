package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.FinancialrecordsInpatientsRelation;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 财务记录与住院关系表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RFinancialrecordsInpatientsRelationService {
    List<FinancialrecordsInpatientsRelation> list(Integer pageSize, Integer pageNum);

    List<FinancialrecordsInpatientsRelation> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

