import request from '@/utils/request'

export function getByFloor(floor_number) {
    return request({
        url: '/model/getByFloor',
        method: 'get',
        params:{
            floor_number:floor_number
        }
    })
}

export function bindBed(modleID,RoomNumber,BedNumber) {
    return request({
        url: '/model/bindBed',
        method: 'get',
        params:{
            ModleID:modleID,
            RoomNumber,
            BedNumber
        }
    })
}

export function _delete(modleID){
    return request({
        url: '/model/delete',
        method: 'get',
        params:{
            ModleID:modleID
        }
    })
}

export function add(data) {
    console.log("add:",data)
    return request({
        url: '/model/add',
        method: 'post',
        data:data
    })
}
export default {
    getByFloor,
    bindBed,
    _delete,
    add
}