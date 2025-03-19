package com.hospital.restful.modules.contractor.service.impl;
import com.hospital.mbg.mapper.FinancialrecordsMapper;
import com.hospital.mbg.mapper.FinancialrecordsMedicalrecordsRelationMapper;
import com.hospital.mbg.model.FinancialrecordsMedicalrecordsRelation;
import com.hospital.restful.modules.contractor.domain.CCMedicalrecordsMixParam;
import com.hospital.restful.modules.contractor.domain.CUMedicalrecordsMixParam;
import com.hospital.restful.modules.contractor.dto.CMedicalrecordsParam;
import com.hospital.restful.modules.contractor.utils.FinancialRecordsUtil;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.contractor.service.CMedicalrecordsService;
import com.hospital.mbg.mapper.MedicalrecordsMapper;
import com.hospital.mbg.model.Medicalrecords;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.hospital.externalservice.service.OssService;
/**
 * <p>
 * 病历管理表 服务实现类
 * 该类依赖于 CMedicalrecordsParamMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */



@Service
public class CMedicalrecordsServiceImpl implements  CMedicalrecordsService {

    @Autowired
    private MedicalrecordsMapper medicalrecordsMapper;
    @Autowired
    private FinancialrecordsMapper financialrecordsMapper;
    @Autowired
    private FinancialrecordsMedicalrecordsRelationMapper financialrecordsMedicalrecordsRelationMapper;

    @Autowired
    private OssService ossService;
    /**
     * 创建新的病历管理表的行
     *
     * @param medicalrecordsParam 创建对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(CMedicalrecordsParam medicalrecordsParam) {
        Medicalrecords medicalrecords = new Medicalrecords();
        BeanUtils.copyProperties(medicalrecordsParam, medicalrecords);
        //业务逻辑处理(自行编写)
        return medicalrecordsMapper.insertSelective(medicalrecords) > 0;
    }

    /**
     * 创建新的病历管理表的行和财务表的行
     *
     * @param medicalrecordsMixParam 创建对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    @Transactional
    public boolean create(CCMedicalrecordsMixParam medicalrecordsMixParam) {
        Medicalrecords medicalrecords = new Medicalrecords();
        BeanUtils.copyProperties(medicalrecordsMixParam.getMedicalrecordsParam(), medicalrecords);
        //业务逻辑处理(自行编写)
        if(medicalrecordsMapper.insertSelective(medicalrecords)<=0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
        return FinancialRecordsUtil.processFinancialRecordsAndRelation(
                medicalrecordsMixParam,
                medicalrecords,
                "RecordID",
                financialrecordsMapper,
                financialrecordsMedicalrecordsRelationMapper,
                FinancialrecordsMedicalrecordsRelation.class
        );
    }

    /**
     * 更新现有的病历管理表
     *
     * @param medicalrecordsParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(CMedicalrecordsParam medicalrecordsParam,Integer id) {
        Medicalrecords medicalrecords = new Medicalrecords();
        medicalrecords.setRecordID(id);
        BeanUtils.copyProperties(medicalrecordsParam, medicalrecords);
        //业务逻辑处理(自行编写)
        return medicalrecordsMapper.updateByPrimaryKeySelective(medicalrecords) > 0;
    }

    /**
     * 更新现有的病历管理表和财务关联表
     *
     * @param medicalrecordsMixParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    @Transactional
    public boolean update(CUMedicalrecordsMixParam medicalrecordsMixParam, Integer id) {
        Medicalrecords medicalrecords = new Medicalrecords();
        medicalrecords.setRecordID(id);
        //业务逻辑处理(自行编写)
        if(medicalrecordsMixParam.getMedicalrecordsParam() != null){
            BeanUtils.copyProperties(medicalrecordsMixParam, medicalrecords);
            if(medicalrecordsMapper.updateByPrimaryKeySelective(medicalrecords)<=0){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }

        return FinancialRecordsUtil.processFinancialRelation(
                medicalrecordsMixParam.getTransactionID(),
                id,
                "RecordID",
                financialrecordsMedicalrecordsRelationMapper,
                FinancialrecordsMedicalrecordsRelation.class
        );
    }

    /**
     * 根据ID删除病历管理表
     *
     * @param medicalrecordsId 删除ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer medicalrecordsId) {
        return medicalrecordsMapper.deleteByPrimaryKey(medicalrecordsId) > 0;
    }

    @Override
    @Transactional
    public boolean deleteImage(Integer id, String value, String ossPath) {
        // 尝试删除 OSS 上的对象
        if (ossService.deleteObject(ossPath)) {
            // 如果删除 OSS 对象成功，尝试更新数据库
            Medicalrecords record = new Medicalrecords();
            record.setRecordID(id);  // 设置主键
            record.setImage_data(value);  // 设置要更新的字段值

            // 更新数据库记录，使用 MBG 自动生成的 updateByPrimaryKeySelective 方法
            int rowsUpdated = medicalrecordsMapper.updateByPrimaryKeySelective(record);

            // 如果数据库更新失败，则手动抛出异常以回滚事务
            if (rowsUpdated <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }

            // 如果数据库更新成功，则返回 true
            return true;
        } else {
            // 如果删除 OSS 对象失败，手动抛出异常以回滚事务
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }
    }

}

