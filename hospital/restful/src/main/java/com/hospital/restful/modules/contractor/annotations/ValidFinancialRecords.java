package com.hospital.restful.modules.contractor.annotations;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = FinancialRecordsValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface ValidFinancialRecords {
    String message() default "当TransactionID不为空时，financialrecordsParam必须为空";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

