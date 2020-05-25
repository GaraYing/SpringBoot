package com.gara.sb.anntation;

import com.gara.sb.config.CoreConfig;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @description: {@link ImportSelector} 自定义ImportSelector
 * @author:  GaraYing
 * @createTime: 2020/5/25 15:34 
 * @Version: 1.0
**/
public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{CoreConfig.class.getName()};
    }
}
