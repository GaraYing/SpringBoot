package com.gara.sb.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.MultiValueMap;

import java.util.List;

public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        MultiValueMap<String, Object> attributes = metadata.getAllAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        List<Object> nameProperty = attributes.get("name");
        List<Object> valueProperty = attributes.get("value");

        Object property = System.getProperty(String.valueOf(nameProperty.get(0)));

        return property.equals(valueProperty.get(0));
    }
}
