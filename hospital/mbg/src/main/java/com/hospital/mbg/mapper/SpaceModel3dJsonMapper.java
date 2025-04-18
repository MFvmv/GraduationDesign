package com.hospital.mbg.mapper;

import com.hospital.mbg.model.SpaceModel3dJson;
import com.hospital.mbg.model.SpaceModel3dJsonExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpaceModel3dJsonMapper {
    long countByExample(SpaceModel3dJsonExample example);

    int deleteByExample(SpaceModel3dJsonExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SpaceModel3dJson row);

    int insertSelective(SpaceModel3dJson row);

    List<SpaceModel3dJson> selectByExampleWithBLOBs(SpaceModel3dJsonExample example);

    List<SpaceModel3dJson> selectByExample(SpaceModel3dJsonExample example);

    SpaceModel3dJson selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("row") SpaceModel3dJson row, @Param("example") SpaceModel3dJsonExample example);

    int updateByExampleWithBLOBs(@Param("row") SpaceModel3dJson row, @Param("example") SpaceModel3dJsonExample example);

    int updateByExample(@Param("row") SpaceModel3dJson row, @Param("example") SpaceModel3dJsonExample example);

    int updateByPrimaryKeySelective(SpaceModel3dJson row);

    int updateByPrimaryKeyWithBLOBs(SpaceModel3dJson row);

    int updateByPrimaryKey(SpaceModel3dJson row);
}