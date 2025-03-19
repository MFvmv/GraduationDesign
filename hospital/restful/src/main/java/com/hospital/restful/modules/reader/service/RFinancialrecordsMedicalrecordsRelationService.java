package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelation;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 财务记录与病历关系表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RFinancialrecordsMedicalrecordsRelationService {
    List<FinancialrecordsMedicalrecordsRelation> list(Integer pageSize, Integer pageNum);

    List<FinancialrecordsMedicalrecordsRelation> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

