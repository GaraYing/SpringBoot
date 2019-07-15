package com.gara.springbootjdbcdemo.handler;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @ClassName: UserHandler
 * @description: 用户相关
 * @author: GaraYing
 * @create: 2018-12-14 11:30
 * @Version: 1.0
 **/

@Component
public class UserHandler {

    public Mono<ServerResponse> getUser(ServerRequest request){
        return Mono.empty();
    }

    public Mono<ServerResponse> getUserCustomers(ServerRequest request){
        return Mono.empty();
    }

    public Mono<ServerResponse> delUser(ServerRequest request){
        return Mono.empty();
    }
}
