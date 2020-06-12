package com.gara.sb.validation.constraints;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Method;

public class ValueOfEnumValidator implements ConstraintValidator<ValueOfEnum, Object> {
    private Class<? extends Enum<?>> enumClass;
    private String enumMethod;

    @Override
    public void initialize(ValueOfEnum annotation) {
        enumMethod = annotation.enumMethod();
        enumClass = annotation.enumClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
//        int a = Arrays.binarySearch(acceptedValues.toArray(), value);
//        return a > 0;
        if (value == null) {
            return Boolean.FALSE;
        }

        try {
            Method method = enumClass.getMethod(enumMethod,value.getClass());
            Boolean isValid = (Boolean)method.invoke(null, value);
            return isValid;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
