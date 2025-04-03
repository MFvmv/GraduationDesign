package com.hospital.admin.service;

import com.hospital.admin.dto.*;
import com.hospital.common.api.CommonResult;
import com.hospital.mbg.model.RbacUsers;

import java.security.Principal;
import java.util.List;

public interface CustomerService {
    String register(RbacUsersParam rbacUsersParam);

    String login(String username, String password);

    void logout(String username);

    UserInfoResult info(String username);

    List<AppointmentDetailsResult> getAppointmentList(String name);

    List<CaseDetailsResult> getCaseList(String name);

    CommonResult bindPatient(Principal principal, String id_card_number);

    CommonResult addAppointment(Principal principal, AddAppointmentParam addAppointmentParam);

    List<DoctorsInfoResult> getDoctorsInfo();
}
