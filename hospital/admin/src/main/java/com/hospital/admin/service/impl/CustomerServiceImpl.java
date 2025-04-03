package com.hospital.admin.service.impl;

import com.hospital.admin.bo.RbacUsersDetails;
import com.hospital.admin.dao.*;
import com.hospital.admin.dto.*;
import com.hospital.admin.service.CustomerService;
import com.hospital.admin.service.RbacUsersService;
import com.hospital.common.api.CommonResult;
import com.hospital.mbg.mapper.*;
import com.hospital.mbg.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.security.Principal;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private RbacUsersService rbacUsersService;
    @Autowired
    private RbacUserRoleRelationMapper rbacUserRoleRelationMapper;
    @Autowired
    private RbacRolesDao rbacRolesDao;
    @Autowired
    private UserPatientRelationDao userPatientRelationDao;
    @Autowired
    private UserPatientRelationMapper userPatientRelationMapper;
    @Autowired
    private PatientsMapper patientsMapper;
    @Autowired
    private AppointmentDao appointmentDao;
    @Autowired
    private AppointmentsMapper appointmentsMapper;
    @Autowired
    private UserAppointmentRelationMapper userAppointmentRelationMapper;
    @Autowired
    private MedicalrecordsDao medicalrecordsDao;
    @Autowired
    private DoctorsDao doctorsDao;

    @Override
    @Transactional
    public String register(RbacUsersParam rbacUsersParam) {
        RbacUsers rbacUsers = rbacUsersService.register(rbacUsersParam);
        if(rbacUsers == null) return  null;
        RbacUserRoleRelation rbacUserRoleRelation = new RbacUserRoleRelation();
        rbacUserRoleRelation.setUser_id(rbacUsers.getUser_id());
        rbacUserRoleRelation.setRole_id(rbacRolesDao.selectRoleIdByRoleName("Customer"));
        if(rbacUserRoleRelationMapper.insert(rbacUserRoleRelation)<=0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
        String token = rbacUsersService.login(rbacUsersParam.getUsername(), rbacUsersParam.getPassword());
        if(token == null){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return null;
        }
        return token;
    }

    @Override
    public String login(String username, String password) {
        return rbacUsersService.login(username,password);
    }

    @Override
    public void logout(String username) {
        rbacUsersService.logout(username);
    }

    @Override
    public UserInfoResult info(String username) {
        UserInfoResult userInfoResult = new UserInfoResult();
        userInfoResult.setUsername(username);
        userPatientRelationDao.getInfo(userInfoResult);
        return userInfoResult;
    }

    @Override
    public List<AppointmentDetailsResult> getAppointmentList(String name) {
        List<AppointmentDetailsResult> list = appointmentDao.getAppointmentDetailsByUsername(name);
        return list;
    }

    @Override
    public List<CaseDetailsResult> getCaseList(String name) {
        List<CaseDetailsResult> list = medicalrecordsDao.getMedicalrecordsDetailsByUsername(name);
        return list;
    }

    private Integer getUserID(Principal principal){
        return  ((RbacUsersDetails)
                ((UsernamePasswordAuthenticationToken)
                        principal).getPrincipal())
                .getRbacUsers()
                .getUser_id();
    }

    @Override
    public CommonResult bindPatient(Principal principal,String id_card_number) {
        Integer user_id = getUserID(principal);
        PatientsExample example = new PatientsExample();
        example.createCriteria().andId_card_numberEqualTo(id_card_number);
        List<Patients> patients = patientsMapper.selectByExample(example);
        if(patients.size()<=0) return CommonResult.failed("查无此身份证");
        UserPatientRelationExample example1 = new UserPatientRelationExample();
        example1.createCriteria().andPatient_idEqualTo(patients.get(0).getPatientID());
        List<UserPatientRelation> userPatientRelations = userPatientRelationMapper.selectByExample(example1);
        if(userPatientRelations.size()>0){
            UserPatientRelation userPatientRelation = userPatientRelations.get(0);
            if(userPatientRelation.getUser_id() != user_id) return CommonResult.failed("身份证已经被别人绑定了");
            UserPatientRelation upr = new UserPatientRelation();
            upr.setPatient_id(patients.get(0).getPatientID());
            int r = userPatientRelationMapper.updateByExampleSelective(upr,example1);
            if(r>0) return CommonResult.success("用户绑定病人信息更新成功");
            return  CommonResult.failed("用户绑定病人信息更新失败");
        }
        UserPatientRelation upr = new UserPatientRelation();
        upr.setUser_id(user_id);
        upr.setPatient_id(patients.get(0).getPatientID());
        int r = userPatientRelationMapper.insert(upr);
        if(r>0) return CommonResult.success("用户绑定病人信息创建成功");
        return  CommonResult.failed("用户绑定病人信息创建失败");
    }

    @Override
    @Transactional
    public CommonResult addAppointment(Principal principal, AddAppointmentParam addAppointmentParam) {
        Integer user_id = getUserID(principal);
        UserPatientRelationExample example = new UserPatientRelationExample();
        example.createCriteria().andUser_idEqualTo(user_id);
        List<UserPatientRelation> list = userPatientRelationMapper.selectByExample(example);
        Appointments appointments = new Appointments();
        if(list.size()>0) appointments.setPatientID(list.get(0).getPatient_id());
        appointments.setAppointmentDate(addAppointmentParam.getAppointmentDate());
        appointments.setAppointmentSession(addAppointmentParam.getAppointmentSession());
        appointments.setDoctorID(addAppointmentParam.getDoctorID());
        if(appointmentsMapper.insertSelective(appointments)<=0) return CommonResult.failed("添加失败");
        UserAppointmentRelation userAppointmentRelation = new UserAppointmentRelation();
        userAppointmentRelation.setAppointment_id(appointments.getAppointmentID());
        userAppointmentRelation.setUser_id(user_id);
        if(userAppointmentRelationMapper.insert(userAppointmentRelation)<=0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return CommonResult.failed("添加失败");
        }
        return  CommonResult.success(null,"添加成功");
    }

    @Override
    public List<DoctorsInfoResult> getDoctorsInfo() {
        List<DoctorsInfoResult> list = doctorsDao.getInfo();
        return list;
    }


}
