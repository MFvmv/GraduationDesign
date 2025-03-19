import request from '@/utils/request'

const baseUrl = "/dataAnalysis"

export function keyMetrics() {
    return request({
        url:baseUrl+'/key-metrics',
        method:'get'
    })
}

export function outpatientTrend() {
    return request({
        url:baseUrl+'/outpatient-trend',
        method:'get'
    })
}


export function revenueComposition() {
    return request({
        url:baseUrl+'/revenue-composition',
        method:'get'
    })
}

export function monthlyRevenueTrend() {
    return request({
        url:baseUrl+'/monthly-revenue-trend',
        method:'get'
    })
}

export function dailyQuantityChange() {
    return request({
        url:baseUrl+'/daily-quantity-change',
        method:'get'
    })
}

export function bedUsage() {
    return request({
        url:baseUrl+'/bed-usage',
        method:'get'
    })
}
