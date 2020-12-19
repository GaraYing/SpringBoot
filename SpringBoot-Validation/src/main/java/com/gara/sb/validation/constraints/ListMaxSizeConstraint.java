package com.gara.sb.validation.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * 集合大小校验
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ListMaxSizeConstraintValidator.class})
public @interface ListMaxSizeConstraint {

    String message() default "集合参数不合法";

    Class<?>[] groups() default {};

    int maxSize() default Integer.MAX_VALUE;

    Class<? extends Payload>[] payload() default {};
}
