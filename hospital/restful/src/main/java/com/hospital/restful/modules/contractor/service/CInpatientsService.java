package com.hospital.restful.modules.contractor.service;

import com.hospital.restful.modules.contractor.domain.CCInpatientsMixParam;
import com.hospital.restful.modules.contractor.domain.CUInpatientsMixParam;
import com.hospital.restful.modules.contractor.dto.CInpatientsParam;

/**
 * <p>
 * 住院管理表 服务类
 * 该接口提供了对预约的增、删、改、查等操作方法。
 * 实现类需实现这些方法以满足业务需求。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */

public interface CInpatientsService {
    /**
     * 创建新的住院管理表的行
     *
     * @param cInpatientsParam 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(CInpatientsParam cInpatientsParam);

    /**
     * 创建新的住院管理表的行和财务表的行
     *
     * @param inpatientsMixParam 预约对象
     * @return 创建成功返回true，否则返回false
     */
    boolean create(CCInpatientsMixParam inpatientsMixParam);

    /**
     * 更新现有的住院管理表
     *
     * @param cInpatientsParam 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(CInpatientsParam cInpatientsParam,Integer id);

    /**
     * 更新现有的住院管理表和财务表的行
     *
     * @param inpatientsMixParam 预约对象
     * @return 更新成功返回true，否则返回false
     */
    boolean update(CUInpatientsMixParam inpatientsMixParam, Integer id);
    /**
     * 根据ID删除住院管理表
     *
     * @param cInpatientsParamId 预约ID
     * @return 删除成功返回true，否则返回false
     */
    boolean delete(Integer cInpatientsParamId);
}

