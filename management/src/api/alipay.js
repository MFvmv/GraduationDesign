import request from '@/utils/request'

export function query(outTradeNo) {
    return request({
        url:'/alipay/query',
        method:'get',
        params:{
            outTradeNo
        }
    })
}
/**
 * data:{
 * outTradeNo,//商户订单号，商家自定义，保持唯一性
 * subject,//商品的标题/交易标题/订单标题/订单关键字等
 * totalAmount,//订单总金额，单位为元，精确到小数点后两位
 * }
 */
export function webPay(params) {
    return request({
        url:'/alipay/webPay',
        method:'get',
        params
    })
}

  