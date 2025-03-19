package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Drugconsumption;
import com.hospital.mbg.model.DrugconsumptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DrugconsumptionMapper {
    long countByExample(DrugconsumptionExample example);

    int deleteByExample(DrugconsumptionExample example);

    int deleteByPrimaryKey(Integer ConsumptionID);

    int insert(Drugconsumption row);

    int insertSelective(Drugconsumption row);

    List<Drugconsumption> selectByExample(DrugconsumptionExample example);

    Drugconsumption selectByPrimaryKey(Integer ConsumptionID);

    int updateByExampleSelective(@Param("row") Drugconsumption row, @Param("example") DrugconsumptionExample example);

    int updateByExample(@Param("row") Drugconsumption row, @Param("example") DrugconsumptionExample example);

    int updateByPrimaryKeySelective(Drugconsumption row);

    int updateByPrimaryKey(Drugconsumption row);
}