package com.hospital.restful.modules.contractor.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

public class FinancialRecordsValidator implements ConstraintValidator<ValidFinancialRecords, Object> {

    @Override
    public void initialize(ValidFinancialRecords constraintAnnotation) {
        // 可选的初始化逻辑
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        // 如果对象为 null，由其他约束（如 @NotNull）处理
        if (value == null) {
            return true;
        }
        try {
            // 通过反射获取 TransactionID
            Method getTransactionID = value.getClass().getMethod("getTransactionID");
            Object transactionID = getTransactionID.invoke(value);

            // 如果 TransactionID 不为 null，则要求 financialrecordsParam 必须为 null
            if (transactionID != null) {
                Method getFinancialrecordsParam = value.getClass().getMethod("getFinancialrecordsParam");
                Object financialrecordsParam = getFinancialrecordsParam.invoke(value);
                return financialrecordsParam == null;
            }
        } catch (NoSuchMethodException e) {
            // 如果没有找到相关方法，可以认为该约束不适用，返回 true
            return true;
        } catch (Exception e) {
            // 其它异常视为校验失败（你也可以记录日志后返回 false）
            return false;
        }
        return true;
    }
}
