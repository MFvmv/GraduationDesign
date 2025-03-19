package com.hospital.externalservice.service;



import com.hospital.externalservice.dto.OssCallbackResult;
import com.hospital.externalservice.dto.OssPolicyResult;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss对象存储管理Service
 * Created by macro on 2018/5/17.
 */
public interface OssService {
    /**
     * Oss上传策略生成
     */
    OssPolicyResult policy();
    /**
     * Oss上传成功回调
     */
    OssCallbackResult callback(HttpServletRequest request);
    /**
     * Oss删除对象
     */
    boolean deleteObject(String objectKey);
}
