package com.wisezone.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@Component
public class TokenFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        // 验证是否有请求参数 token

        // 获取 请求/响应 对象
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpResponse response = exchange.getResponse();

        // 获取请求参数
        String token = request.getQueryParams().getFirst("token");

        // 判断 token 是否存在
        if(StringUtils.isEmpty(token)){
            System.out.println("无 token 凭证...");
            try {
                Map map = new HashMap<>();
                // 响应状态
                map.put("code", -1);
                // 响应内容
                map.put("msg", "缺少凭证");

                byte[] bytes = new ObjectMapper().writeValueAsBytes(map);

                // 将响应的数据进行转换
                DataBuffer dataBuffer = response.bufferFactory().wrap(bytes);

                // 设置响应对象状态码 401
                response.setStatusCode(HttpStatus.UNAUTHORIZED);
                // 设置响应对象内容并且指定编码，否则在浏览器中会中文乱码
                response.getHeaders().add("Content-Type", "text/plain;charset=UTF-8");

                return response.writeWith(Mono.just(dataBuffer));

            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        }

        System.out.println("有 token 凭证...");

        return chain.filter(exchange); // 放行
    }

    @Override
    public int getOrder() {
        return -1;
    }


}
