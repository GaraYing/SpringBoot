package com.gara.sbcommon.config;

import com.google.common.collect.Lists;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SwaggerConfig
 * @description: swagger api config
 * @author: GaraYing
 * @createTime: 2019-03-27 14:57
 * @Version: 1.0
 **/

@Configuration
@EnableSwagger2
@ConfigurationProperties(prefix = "swagger")
//@ConditionalOnMissingBean
@ConditionalOnProperty(prefix = "swagger", value = "enable", havingValue = "true")
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiinfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gara"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());

    }

    /**
     * 配置认证上下文
     *
     * @return
     */
    private List<SecurityContext> securityContexts() {
        return Lists.newArrayList(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build());

    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Lists.newArrayList(new SecurityReference("Authorization", authorizationScopes));
    }

    /**
     * 配置认证模式
     *
     * @return
     */
    private List<SecurityScheme> securitySchemes() {
        return Lists.newArrayList(new ApiKey("Authorization", "Authorization", "header"));
    }

    /**
     * 项目信息
     *
     * @return
     */
    private ApiInfo apiinfo() {
        return new ApiInfoBuilder()
                .title("TestAPI From Swagger")
                .description("这是Swagger描述")
                .termsOfServiceUrl("http://www.xxx.com/")
                .contact(new Contact("Gara", "", ""))
                .version("1.0")
                .build();
    }
}
