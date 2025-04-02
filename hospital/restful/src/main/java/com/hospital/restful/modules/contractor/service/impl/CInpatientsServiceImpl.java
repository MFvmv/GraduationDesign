package com.hospital.restful.modules.contractor.service.impl;
import com.hospital.mbg.mapper.FinancialrecordsInpatientsRelationMapper;
import com.hospital.mbg.mapper.FinancialrecordsMapper;
import com.hospital.mbg.model.FinancialrecordsInpatientsRelation;
import com.hospital.restful.modules.contractor.dto.CCInpatientsMixParam;
import com.hospital.restful.modules.contractor.dto.CUInpatientsMixParam;
import com.hospital.restful.modules.contractor.domain.CInpatientsParam;
import com.hospital.restful.modules.contractor.utils.FinancialRecordsUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.contractor.service.CInpatientsService;
import com.hospital.mbg.mapper.InpatientsMapper;
import com.hospital.mbg.model.Inpatients;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * <p>
 * 住院管理表 服务实现类
 * 该类依赖于 CInpatientsParamMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */



@Service
public class CInpatientsServiceImpl implements  CInpatientsService {

    @Autowired
    private InpatientsMapper inpatientsMapper;
    @Autowired
    private FinancialrecordsMapper financialrecordsMapper;
    @Autowired
    private FinancialrecordsInpatientsRelationMapper financialrecordsInpatientsRelationMapper;

    /**
     * 创建新的住院管理表的行
     *
     * @param inpatientsParam 创建对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(CInpatientsParam inpatientsParam) {
        Inpatients inpatients = new Inpatients();
        BeanUtils.copyProperties(inpatientsParam, inpatients);
        //业务逻辑处理(自行编写)
        return inpatientsMapper.insertSelective(inpatients) > 0;
    }


    /**
     * 创建新的住院管理表的行和财务表的行
     *
     * @param inpatientsMixParam 创建对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    @Transactional
    public boolean create(CCInpatientsMixParam inpatientsMixParam) {
        Inpatients inpatients = new Inpatients();
        BeanUtils.copyProperties(inpatientsMixParam.getInpatientsParam(), inpatients);
        //业务逻辑处理(自行编写)
        if(inpatientsMapper.insertSelective(inpatients) <= 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }

        return FinancialRecordsUtil.processFinancialRecordsAndRelation(
                inpatientsMixParam,
                inpatients,
                "InpatientID",
                financialrecordsMapper,
                financialrecordsInpatientsRelationMapper,
                FinancialrecordsInpatientsRelation.class
        );
    }

    /**
     * 更新现有的住院管理表
     *
     * @param inpatientsParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(CInpatientsParam inpatientsParam,Integer id) {
        Inpatients inpatients = new Inpatients();
        inpatients.setInpatientID(id);
        BeanUtils.copyProperties(inpatientsParam, inpatients);
        //业务逻辑处理(自行编写)
        return inpatientsMapper.updateByPrimaryKeySelective(inpatients) > 0;
    }

    /**
     * 更新现有的住院管理表和财务关联表
     *
     * @param inpatientsMixParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    @Transactional
    public boolean update(CUInpatientsMixParam inpatientsMixParam, Integer id) {
        Inpatients inpatients = new Inpatients();
        inpatients.setInpatientID(id);
        //业务逻辑处理(自行编写)
        if(inpatientsMixParam.getInpatientsParam() != null){
            BeanUtils.copyProperties(inpatientsMixParam, inpatients);
            if(inpatientsMapper.updateByPrimaryKeySelective(inpatients) <= 0){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
        return FinancialRecordsUtil.processFinancialRelation(
                inpatientsMixParam.getTransactionID(),
                id,
                "InpatientID",
                financialrecordsInpatientsRelationMapper,
                FinancialrecordsInpatientsRelation.class
        );
    }


    /**
     * 根据ID删除住院管理表
     *
     * @param inpatientsId 删除ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer inpatientsId) {
        return inpatientsMapper.deleteByPrimaryKey(inpatientsId) > 0;
    }
}

