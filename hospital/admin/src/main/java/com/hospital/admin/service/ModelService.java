package com.hospital.admin.service;

import com.hospital.admin.dto.AddModel3DJSONParam;
import com.hospital.mbg.model.SpaceModel3dJson;

import java.util.List;

public interface ModelService {

    List<SpaceModel3dJson> getByFloor(int floor_number);

    boolean bindBed(int ModleID,String RoomNumber,int BedNumber);

    boolean delete(int modleID);

    int add(AddModel3DJSONParam param);
}
