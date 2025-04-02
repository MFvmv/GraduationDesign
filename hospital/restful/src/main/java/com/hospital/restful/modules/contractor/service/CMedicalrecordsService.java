package com.hospital.restful.modules.contractor.service;

import com.hospital.restful.modules.contractor.dto.CCMedicalrecordsMixParam;
import com.hospital.restful.modules.contractor.dto.CUMedicalrecordsMixParam;
import com.hospital.restful.modules.contractor.domain.CMedicalrecordsParam;

/**
 * <p>
 * 病历管理表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */

public interface CMedicalrecordsService {
    /**
     * 创建新的病历管理表的行
     *
     * @param cMedicalrecordsParam 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(CMedicalrecordsParam cMedicalrecordsParam);

    /**
     * 创建新的病历管理表的行和财务表的行
     *
     * @param medicalrecordsMixParam 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(CCMedicalrecordsMixParam medicalrecordsMixParam);

    /**
     * 更新现有的病历管理表
     *
     * @param cMedicalrecordsParam 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(CMedicalrecordsParam cMedicalrecordsParam,Integer id);

    /**
     * 更新现有的病历管理表和财务关联表
     *
     * @param medicalrecordsMixParam 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(CUMedicalrecordsMixParam medicalrecordsMixParam, Integer id);
    /**
     * 根据ID删除病历管理表
     *
     * @param cMedicalrecordsParamId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer cMedicalrecordsParamId);

    /**
     * 根据ID更新病历管理表的image_data，删除oss的图片
     *
     * @param id 病历管理表的主键RecordID
     * @param value 更新image_data的值
     * @param ossPath 要删除oss的路径
     * @return 删除成功返回true，否则返回false
     */
    boolean deleteImage(Integer id,String value,String ossPath);
}

