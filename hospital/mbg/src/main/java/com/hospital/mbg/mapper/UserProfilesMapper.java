package com.hospital.mbg.mapper;

import com.hospital.mbg.model.UserProfiles;
import com.hospital.mbg.model.UserProfilesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserProfilesMapper {
    long countByExample(UserProfilesExample example);

    int deleteByExample(UserProfilesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserProfiles row);

    int insertSelective(UserProfiles row);

    List<UserProfiles> selectByExampleWithBLOBs(UserProfilesExample example);

    List<UserProfiles> selectByExample(UserProfilesExample example);

    UserProfiles selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") UserProfiles row, @Param("example") UserProfilesExample example);

    int updateByExampleWithBLOBs(@Param("row") UserProfiles row, @Param("example") UserProfilesExample example);

    int updateByExample(@Param("row") UserProfiles row, @Param("example") UserProfilesExample example);

    int updateByPrimaryKeySelective(UserProfiles row);

    int updateByPrimaryKeyWithBLOBs(UserProfiles row);

    int updateByPrimaryKey(UserProfiles row);
}