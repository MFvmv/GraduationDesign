package com.hospital.mbg.mapper;

import com.hospital.mbg.model.RbacUsers;
import com.hospital.mbg.model.RbacUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RbacUsersMapper {
    long countByExample(RbacUsersExample example);

    int deleteByExample(RbacUsersExample example);

    int deleteByPrimaryKey(Integer user_id);

    int insert(RbacUsers row);

    int insertSelective(RbacUsers row);

    List<RbacUsers> selectByExample(RbacUsersExample example);

    RbacUsers selectByPrimaryKey(Integer user_id);

    int updateByExampleSelective(@Param("row") RbacUsers row, @Param("example") RbacUsersExample example);

    int updateByExample(@Param("row") RbacUsers row, @Param("example") RbacUsersExample example);

    int updateByPrimaryKeySelective(RbacUsers row);

    int updateByPrimaryKey(RbacUsers row);
}