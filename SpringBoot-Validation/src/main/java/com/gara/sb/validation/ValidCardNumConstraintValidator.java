package com.gara.sb.validation;

import com.gara.sb.validation.constraints.ValidCardNum;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

/**
 * ConstraintValidator 的实现
 * <p>
 * GARA－0008
 */
public class ValidCardNumConstraintValidator implements ConstraintValidator<ValidCardNum, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext)

    {
        /**
         * 前半部分 + 后半部分 GARA-0008
         * 不用原因： 该方法是用了正则表达式，其次是NPE保护不够
         * 如果没有实现StringUtils.delimitedListToStringArray() 方法的API
         * StringTokenizer(类似枚举)
         * Apache commons-lang StringUtils
         */
//        String[] parts = StringUtils.delimitedListToStringArray(value, "-");
//        if (parts.length != 2) {
//            return false;
//        }

        String[] parts = value.split("-");
        if (ArrayUtils.getLength(parts) != 2) {
            return false;
        }
        String prefix = parts[0];
        String suffix = parts[1];

        boolean isValidPrefix = Objects.equals(prefix, "GARA");

        boolean isValidInteger = org.apache.commons.lang3.StringUtils.isNumeric(suffix);

        return isValidPrefix && isValidInteger;
    }

    @Override
    public void initialize(ValidCardNum constraintAnnotation) {

    }
}
