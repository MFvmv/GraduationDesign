package com.hospital.mbg.mapper;

import com.hospital.mbg.model.UserAppointmentRelation;
import com.hospital.mbg.model.UserAppointmentRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAppointmentRelationMapper {
    long countByExample(UserAppointmentRelationExample example);

    int deleteByExample(UserAppointmentRelationExample example);

    int deleteByPrimaryKey(Integer appointment_id);

    int insert(UserAppointmentRelation row);

    int insertSelective(UserAppointmentRelation row);

    List<UserAppointmentRelation> selectByExample(UserAppointmentRelationExample example);

    UserAppointmentRelation selectByPrimaryKey(Integer appointment_id);

    int updateByExampleSelective(@Param("row") UserAppointmentRelation row, @Param("example") UserAppointmentRelationExample example);

    int updateByExample(@Param("row") UserAppointmentRelation row, @Param("example") UserAppointmentRelationExample example);

    int updateByPrimaryKeySelective(UserAppointmentRelation row);

    int updateByPrimaryKey(UserAppointmentRelation row);
}