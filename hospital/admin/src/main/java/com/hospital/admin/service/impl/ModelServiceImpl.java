package com.hospital.admin.service.impl;

import com.hospital.admin.dto.AddModel3DJSONParam;
import com.hospital.admin.service.ModelService;
import com.hospital.mbg.mapper.HospitalbedsMapper;
import com.hospital.mbg.mapper.SpaceModel3dJsonMapper;
import com.hospital.mbg.model.Hospitalbeds;
import com.hospital.mbg.model.HospitalbedsExample;
import com.hospital.mbg.model.SpaceModel3dJson;
import com.hospital.mbg.model.SpaceModel3dJsonExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    private SpaceModel3dJsonMapper spaceModel3dJsonMapper;
    @Autowired
    private HospitalbedsMapper hospitalbedsMapper;

    @Override
    public List<SpaceModel3dJson> getByFloor(int floor_number) {
        SpaceModel3dJsonExample example = new SpaceModel3dJsonExample();
        example.createCriteria().andFloor_numberEqualTo(floor_number);
        List<SpaceModel3dJson> list =  spaceModel3dJsonMapper.selectByExampleWithBLOBs(example);
        return list;
    }

    @Override
    public boolean bindBed(int ModleID,String RoomNumber,int BedNumber) {
        SpaceModel3dJson spaceModel3dJson = new SpaceModel3dJson();
        spaceModel3dJson.setId(ModleID);
        HospitalbedsExample example = new HospitalbedsExample();
        HospitalbedsExample.Criteria criteria =  example.createCriteria();
        criteria.andRoomNumberEqualTo(RoomNumber);
        criteria.andBedNumberEqualTo(BedNumber);
        List<Hospitalbeds> list = hospitalbedsMapper.selectByExample(example);
        if(list.size()<=0) return  false;
        spaceModel3dJson.setBed_id(list.get(0).getBedID());
        int r = spaceModel3dJsonMapper.updateByPrimaryKeySelective(spaceModel3dJson);
        if(r<=0) return false;
        return true;
    }

    @Override
    public boolean delete(int modleID) {
        int r = spaceModel3dJsonMapper.deleteByPrimaryKey(modleID);
        if(r<=0) return false;
        return true;
    }

    @Override
    public int add(AddModel3DJSONParam param) {
        SpaceModel3dJson spaceModel3dJson = new SpaceModel3dJson();
        BeanUtils.copyProperties(param,spaceModel3dJson);
        int r = spaceModel3dJsonMapper.insertSelective(spaceModel3dJson);
        if(r<=0) return -1;
        return spaceModel3dJson.getId();
    }
}
