package com.hospital.mbg.mapper;

import com.hospital.mbg.model.UserPatientRelation;
import com.hospital.mbg.model.UserPatientRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPatientRelationMapper {
    long countByExample(UserPatientRelationExample example);

    int deleteByExample(UserPatientRelationExample example);

    int deleteByPrimaryKey(@Param("user_id") Integer user_id, @Param("patient_id") Integer patient_id);

    int insert(UserPatientRelation row);

    int insertSelective(UserPatientRelation row);

    List<UserPatientRelation> selectByExample(UserPatientRelationExample example);

    int updateByExampleSelective(@Param("row") UserPatientRelation row, @Param("example") UserPatientRelationExample example);

    int updateByExample(@Param("row") UserPatientRelation row, @Param("example") UserPatientRelationExample example);
}