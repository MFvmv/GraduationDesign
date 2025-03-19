package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Hospitalbeds;
import com.hospital.mbg.model.HospitalbedsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HospitalbedsMapper {
    long countByExample(HospitalbedsExample example);

    int deleteByExample(HospitalbedsExample example);

    int deleteByPrimaryKey(Integer BedID);

    int insert(Hospitalbeds row);

    int insertSelective(Hospitalbeds row);

    List<Hospitalbeds> selectByExample(HospitalbedsExample example);

    Hospitalbeds selectByPrimaryKey(Integer BedID);

    int updateByExampleSelective(@Param("row") Hospitalbeds row, @Param("example") HospitalbedsExample example);

    int updateByExample(@Param("row") Hospitalbeds row, @Param("example") HospitalbedsExample example);

    int updateByPrimaryKeySelective(Hospitalbeds row);

    int updateByPrimaryKey(Hospitalbeds row);
}