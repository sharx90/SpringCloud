package com.hxzy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 开启 Feign 声明式调用
public class SpringcloudUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudUserApplication.class, args);
	}

	@Bean
	@LoadBalanced  // 本地负载均衡  (采用轮询)
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

//	@Bean
//	public IRule iRule(){ // 设置 Ribbon 负载均衡策略
//		return new RandomRule();
//	}


}
