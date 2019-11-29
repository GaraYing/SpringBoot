package com.gara.sb.validation.constraints;

import com.gara.sb.validation.ValidCardNumConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 合法的卡号校验：GARA-0008
 * 步骤：1. 复制成熟的Bean Validation 校验
 * 2. 参考和理解 @Constraint
 * 3. 实现ConstraintValidator接口
 * 4. 将实现的ValidCardNumConstraintValidator添加到@Constraint的validatedBy
 * 5. ValidCardNum添加 message()
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {ValidCardNumConstraintValidator.class}
)
public @interface ValidCardNum {

    String message() default "{com.gara.validation.constraints.ValidCardNum.message}";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
