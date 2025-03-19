package com.hospital.restful.modules.reader.service;
import com.hospital.mbg.model.FinancialrecordsDrugconsumptionRelation;
import java.util.List;
import com.hospital.common.api.CommonResult;

/**
 * <p>
 * 财务记录与药品消耗关系表 服务类
 * </p>
 * @author MF
 * @since 2025-03-10
 */

public interface RFinancialrecordsDrugconsumptionRelationService {
    List<FinancialrecordsDrugconsumptionRelation> list(Integer pageSize, Integer pageNum);

    List<FinancialrecordsDrugconsumptionRelation> searchByField(String field,Object value,Integer pageSize, Integer pageNum);
}

