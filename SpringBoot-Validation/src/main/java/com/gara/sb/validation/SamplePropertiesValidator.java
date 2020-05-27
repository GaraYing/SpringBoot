package com.gara.sb.validation;

import com.gara.sb.property.SampleProperties;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

/**
 * @description: 自定义验证 {@link Validator}
 * @author:  GaraYing
 * @createTime: 2020/5/27 16:25
 * @Version: 1.0
**/
public class SamplePropertiesValidator implements Validator {

    final Pattern pattern = Pattern.compile("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$");

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == SampleProperties.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmpty(errors, "host", "host.empty");
        ValidationUtils.rejectIfEmpty(errors, "port", "port.empty");
        SampleProperties properties = (SampleProperties) target;
        if (properties.getHost() != null && !this.pattern.matcher(properties.getHost()).matches()) {
            errors.rejectValue("host", "Invalid host","Invalid host");
        }
    }
}
