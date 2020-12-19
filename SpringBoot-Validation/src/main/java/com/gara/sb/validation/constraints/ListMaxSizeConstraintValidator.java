package com.gara.sb.validation.constraints;

import com.gara.sb.domain.User;
import com.gara.sb.validation.ValidList;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ListMaxSizeConstraintValidator implements ConstraintValidator<ListMaxSizeConstraint, ValidList<User>> {
    private int maxListSize;

    @Override
    public void initialize(ListMaxSizeConstraint constraintAnnotation) {
        maxListSize = constraintAnnotation.maxSize();
    }

    @Override
    public boolean isValid(ValidList<User> value, ConstraintValidatorContext context) {
        return value.size() <= maxListSize;
    }
}
