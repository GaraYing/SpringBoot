package com.gara.springbootjdbcdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @ClassName: SwaggerConfig
 * @description: swagger api config
 * @author: GaraYing
 * @createTime: 2019-03-27 14:57
 * @Version: 1.0
 **/

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiinfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gara.springbootjdbcdemo"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());

    }

    /**
     * 配置认证上下文
     * @return
     */
    private List<SecurityContext> securityContexts() {
        return newArrayList(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.any())
                .build());

    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return newArrayList(new SecurityReference("Authorization", authorizationScopes));
    }

    /**
     * 配置认证模式
     * @return
     */
    private List<ApiKey> securitySchemes() {
        return newArrayList(new ApiKey("Authorization","Authorization","header"));
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
                .termsOfServiceUrl("http://www.fadada.com/")
                .contact("Gara")
                .version("1.0")
                .build();
    }

}
