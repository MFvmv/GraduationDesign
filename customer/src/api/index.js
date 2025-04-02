import request from './request';

const baseURL = "/customer";

export const getAppointmentList = () => {
  return request({
    url: baseURL + '/appointmentList',
    method: 'GET'
  })
}


export const getCaseList = () => {
  return request({
    url: baseURL + '/caseList',
    method: 'GET'
  });
};

export const bindPatient = (params) => {
  return request({
    url: baseURL + '/bindPatient',
    method: 'POST',
    params
  });
};

// 登录出接口
export const logout = () => {
  return request({
    url: baseURL + '/logout',
    method: 'GET'
  })
}
// 获得用户信息的接口
export const getUserInfo = ()=>{
  return request({
    url: baseURL + '/info',
    method: 'GET'
  })
}

// 登录接口
export const login = (data) => {
  return request({
    url: baseURL + '/login',
    method: 'POST',
    data
  });
};

// 注册
export const register = (data) => {
  console.log("data:",data)
  return request({
    url: baseURL + '/register',
    method: 'POST',
    data
  });
};


