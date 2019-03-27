package com.gara.springbootjdbcdemo.config;

import com.gara.springbootjdbcdemo.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @ClassName: RoutingConfiguration
 * @description: 请求路由配置
 * @author: GaraYing
 * @create: 2019-01-11 13:43
 * @Version: 1.0
 **/

@Configuration
public class RoutingConfiguration {

    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler){
        return route(GET("/user").and(accept(APPLICATION_JSON)), userHandler::getUser)
                .andRoute(GET("{user}/customer").and(accept(APPLICATION_JSON)), userHandler::getUserCustomers)
                .andRoute(DELETE("/{user}").and(accept(APPLICATION_JSON)), userHandler::delUser);
    }

}
