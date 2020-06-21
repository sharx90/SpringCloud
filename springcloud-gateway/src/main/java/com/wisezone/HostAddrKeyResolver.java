package com.wisezone;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

public class HostAddrKeyResolver implements KeyResolver {
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
        //return Mono.just(exchange.getRequest().getURI().getPath());
    }

//用uri去限流
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }


    //用用户去限流
//    @Bean
//    KeyResolver userKeyResolver() {
//        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));
//    }
}
