package com.hospital.restful.modules.contractor.service.impl;


import com.hospital.externalservice.dao.FinancialrecordsDao;
import com.hospital.externalservice.domain.AliPayParam;
import com.hospital.mbg.mapper.AlipaytransactionsMapper;
import com.hospital.mbg.model.Alipaytransactions;
import com.hospital.mbg.model.AlipaytransactionsExample;
import com.hospital.restful.modules.contractor.dto.CFinancialrecordsParam;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.hospital.restful.modules.contractor.service.CFinancialrecordsService;
import com.hospital.mbg.mapper.FinancialrecordsMapper;
import com.hospital.mbg.model.Financialrecords;

import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 财务管理表 服务实现类
 * 该类依赖于 CFinancialrecordsParamMapper 进行数据库操作，
 * 通过注入的方式获取该依赖。
 * </p>
 *
 * @author MF
 * @since 2025-02-25
 */



@Service
public class CFinancialrecordsServiceImpl implements  CFinancialrecordsService {

    @Autowired
    private FinancialrecordsMapper financialrecordsMapper;

    @Autowired
    private FinancialrecordsDao financialrecordsDao;

    @Autowired
    private AlipaytransactionsMapper alipaytransactionsMapper;
    /**
     * 创建新的财务管理表的行
     *
     * @param financialrecordsParam 创建对象
     * @return 创建成功返回true，否则返回false
     */
    @Override
    public boolean create(CFinancialrecordsParam financialrecordsParam) {
        Financialrecords financialrecords = new Financialrecords();
        BeanUtils.copyProperties(financialrecordsParam, financialrecords);
        //业务逻辑处理(自行编写)
        if(financialrecords.getPaymentStatus() == "已支付"){
            financialrecords.setTransactionDate(new Date());
        }
        return financialrecordsMapper.insertSelective(financialrecords) > 0;
    }

    /**
     * 更新现有的财务管理表
     *
     * @param financialrecordsParam 更新对象
     * @return 更新成功返回true，否则返回false
     */
    @Override
    public boolean update(CFinancialrecordsParam financialrecordsParam,Integer id) {
        Financialrecords financialrecords = new Financialrecords();
        financialrecords.setTransactionID(id);
        BeanUtils.copyProperties(financialrecordsParam, financialrecords);
        //业务逻辑处理(自行编写)
        if(financialrecords.getPaymentStatus().equals("已支付")){
            financialrecords.setTransactionDate(new Date());
        }
        return financialrecordsMapper.updateByPrimaryKeySelective(financialrecords) > 0;
    }

    /**
     * 根据ID删除财务管理表
     *
     * @param financialrecordsId 删除ID
     * @return 删除成功返回true，否则返回false
     */
    @Override
    public boolean delete(Integer financialrecordsId) {
        return financialrecordsMapper.deleteByPrimaryKey(financialrecordsId) > 0;
    }

    @Override
    @Transactional
    public boolean processAlipayWebPay(AliPayParam aliPayParam) {
        // 1. 判断 outTradeNo 是否以 "alipay:" 开头
        String outTradeNo = aliPayParam.getOutTradeNo();
        if (outTradeNo == null || !outTradeNo.startsWith("alipay:")) {
            return false;
        }

        // 2. 分割 outTradeNo 字符串，以 ":" 分隔，忽略第一个 "alipay" 部分
        String[] parts = outTradeNo.split(":");
        if (parts.length < 2) {
            return false;
        }
        List<Integer> idList = new ArrayList<>();
        for (int i = 1; i < parts.length; i++) {
            try {
                idList.add(Integer.valueOf(parts[i]));
            } catch (NumberFormatException e) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }

        // 3. 根据 id 数组批量更新 financialrecords 表中对应记录的 OrderNumber 字段
        int updateCount = financialrecordsDao.updateOrderNumberByIdList(idList, outTradeNo);
        if (updateCount <= 0) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return false;
        }

        // 4. 插入或更新支付宝交易记录，设置 OrderNumber 和 TotalAmount，TradeStatus 使用默认值
        Alipaytransactions alipaytransactions = new Alipaytransactions();
        alipaytransactions.setOrderNumber(outTradeNo);
        alipaytransactions.setTotalAmount(aliPayParam.getTotalAmount());
        // 如有需要，也可以设置 TradeStatus，例如：alipaytransactions.setTradeStatus("待付款");

        AlipaytransactionsExample example = new AlipaytransactionsExample();
        example.createCriteria().andOrderNumberEqualTo(outTradeNo);
        List<Alipaytransactions> list = alipaytransactionsMapper.selectByExample(example);
        if (list.size() > 0) {
            int count = alipaytransactionsMapper.updateByExampleSelective(alipaytransactions, example);
            if (count <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        } else {
            int count = alipaytransactionsMapper.insertSelective(alipaytransactions);
            if (count <= 0) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                return false;
            }
        }
        return true;
    }
}

