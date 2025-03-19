package com.hospital.mbg.mapper;

import com.hospital.mbg.model.Druginventory;
import com.hospital.mbg.model.DruginventoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DruginventoryMapper {
    long countByExample(DruginventoryExample example);

    int deleteByExample(DruginventoryExample example);

    int deleteByPrimaryKey(Integer DrugID);

    int insert(Druginventory row);

    int insertSelective(Druginventory row);

    List<Druginventory> selectByExample(DruginventoryExample example);

    Druginventory selectByPrimaryKey(Integer DrugID);

    int updateByExampleSelective(@Param("row") Druginventory row, @Param("example") DruginventoryExample example);

    int updateByExample(@Param("row") Druginventory row, @Param("example") DruginventoryExample example);

    int updateByPrimaryKeySelective(Druginventory row);

    int updateByPrimaryKey(Druginventory row);
}