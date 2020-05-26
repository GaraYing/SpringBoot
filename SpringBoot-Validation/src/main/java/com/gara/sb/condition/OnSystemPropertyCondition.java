package com.gara.sb.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Map;

/**
 * @description: 自定义是实现 {@link Condition}
 * @author:  GaraYing
 * @createTime: 2020/5/26 11:36
 * @Version: 1.0
**/
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String, Object> attributes = metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        String nameProperty = String.valueOf(attributes.get("name"));
        String valueProperty = String.valueOf(attributes.get("value"));

        Object property = System.getProperty(nameProperty);

        return property.equals(valueProperty);
    }
}
