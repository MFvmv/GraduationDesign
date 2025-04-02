package com.hospital.admin.service;

import com.hospital.admin.dto.AppointmentDetailsResult;
import com.hospital.admin.dto.CaseDetailsResult;
import com.hospital.admin.dto.RbacUsersParam;
import com.hospital.admin.dto.UserInfoResult;
import com.hospital.common.api.CommonResult;
import com.hospital.mbg.model.RbacUsers;

import java.util.List;

public interface CustomerService {
    String register(RbacUsersParam rbacUsersParam);

    String login(String username, String password);

    void logout(String username);

    UserInfoResult info(String username);

    List<AppointmentDetailsResult> getAppointmentList(String name);

    List<CaseDetailsResult> getCaseList(String name);

    CommonResult bindPatient(Integer user_id,String id_card_number);
}
