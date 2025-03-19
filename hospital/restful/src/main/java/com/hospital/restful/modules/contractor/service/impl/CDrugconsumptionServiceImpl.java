package com.hospital.restful.modules.contractor.service.impl;
import com.hospital.mbg.mapper.FinancialrecordsDrugconsumptionRelationMapper;
import com.hospital.mbg.mapper.FinancialrecordsMapper;
import com.hospital.mbg.model.FinancialrecordsDrugconsumptionRelation;
import com.hospital.restful.modules.contractor.domain.CCDrugconsumptionMixParam;
import com.hospital.restful.modules.contractor.domain.CUDrugconsumptionMixParam;
import com.hospital.restful.modules.contractor.dto.CDrugconsumptionParam;
import com.hospital.restful.modules.contractor.utils.FinancialRecordsUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.contractor.service.CDrugconsumptionService;
import com.hospital.mbg.mapper.DrugconsumptionMapper;
import com.hospital.mbg.model.Drugconsumption;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * <p>
 * 药品消耗记录表 服务实现类
 * 该类依赖于 CDrugconsumptionParamMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */



@Service
public class CDrugconsumptionServiceImpl implements  CDrugconsumptionService {

    @Autowired
    private DrugconsumptionMapper drugconsumptionMapper;
    @Autowired
    private FinancialrecordsMapper financialrecordsMapper;
    @Autowired
    private FinancialrecordsDrugconsumptionRelationMapper financialrecordsDrugconsumptionRelationMapper;
    /**
     * 创建新的药品消耗记录表的行
     *
     * @param drugconsumptionParam 创建对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(CDrugconsumptionParam drugconsumptionParam) {
        Drugconsumption drugconsumption = new Drugconsumption();
        BeanUtils.copyProperties(drugconsumptionParam, drugconsumption);
        //业务逻辑处理(自行编写)
        return drugconsumptionMapper.insertSelective(drugconsumption) > 0;
    }

    /**
     * 创建新的药品消耗记录表的行和财务表的行
     *
     * @param drugconsumptionMixParam 参数对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    @Transactional
    public boolean create(CCDrugconsumptionMixParam drugconsumptionMixParam) {
        Drugconsumption drugconsumption = new Drugconsumption();
        BeanUtils.copyProperties(drugconsumptionMixParam.getDrugconsumptionParam(), drugconsumption);
        //业务逻辑处理(自行编写)
        if(drugconsumptionMapper.insertSelective(drugconsumption)<=0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return FinancialRecordsUtil.processFinancialRecordsAndRelation(
                drugconsumptionMixParam,
                drugconsumption,
                "ConsumptionID",
                financialrecordsMapper,
                financialrecordsDrugconsumptionRelationMapper,
                FinancialrecordsDrugconsumptionRelation.class
        );
    }



    /**
     * 更新现有的药品消耗记录表
     *
     * @param drugconsumptionParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    @Transactional
    public boolean update(CDrugconsumptionParam drugconsumptionParam, Integer id) {
        Drugconsumption drugconsumption = new Drugconsumption();
        drugconsumption.setConsumptionID(id);
        if(drugconsumptionParam!=null){
            BeanUtils.copyProperties(drugconsumptionParam, drugconsumption);
            //业务逻辑处理(自行编写)
            return drugconsumptionMapper.updateByPrimaryKeySelective(drugconsumption) > 0;
        }
       return false;
    }

    /**
     * 更新现有的药品消耗记录表和财务关联表
     *
     * @param drugconsumptionMixParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    @Transactional
    public boolean update(CUDrugconsumptionMixParam drugconsumptionMixParam, Integer id) {
        Drugconsumption drugconsumption = new Drugconsumption();
        drugconsumption.setConsumptionID(id);
        //业务逻辑处理(自行编写)
        if(drugconsumptionMixParam.getDrugconsumptionParam() != null){
            BeanUtils.copyProperties(drugconsumptionMixParam.getDrugconsumptionParam(), drugconsumption);
            if(drugconsumptionMapper.updateByPrimaryKeySelective(drugconsumption) <= 0){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
        return FinancialRecordsUtil.processFinancialRelation(
                drugconsumptionMixParam.getTransactionID(),
                id,
                "ConsumptionID",
                financialrecordsDrugconsumptionRelationMapper,
                FinancialrecordsDrugconsumptionRelation.class
        );
    }

    /**
     * 根据ID删除药品消耗记录表
     *
     * @param drugconsumptionId 删除ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer drugconsumptionId) {
        return drugconsumptionMapper.deleteByPrimaryKey(drugconsumptionId) > 0;
    }
}

