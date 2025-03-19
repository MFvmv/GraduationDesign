package com.hospital.admin.service.impl;

import com.hospital.mbg.mapper.RbacPermissionsMapper;
import com.hospital.mbg.model.RbacPermissions;
import com.hospital.mbg.model.RbacPermissionsExample;
import com.hospital.admin.service.RbacPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RbacPermissionsServiceImpl implements RbacPermissionsService {

    @Autowired
    private RbacPermissionsMapper rbacPermissionsMapper;

    @Override
    public List<RbacPermissions> listAll() {
        return rbacPermissionsMapper.selectByExample(new RbacPermissionsExample());
    }
}
