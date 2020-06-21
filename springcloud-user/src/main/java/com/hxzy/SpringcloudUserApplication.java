package com.hxzy;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableHystrixDashboard
@EnableHystrix
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

	@Bean
	public IRule iRule(){ // 设置 Ribbon 负载均衡策略
		return new RandomRule();
	}

	@Bean
	public ServletRegistrationBean<HystrixMetricsStreamServlet> getServlet(){
		HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> servletRegistrationBean = new ServletRegistrationBean();
		servletRegistrationBean.setServlet(hystrixMetricsStreamServlet);
		servletRegistrationBean.addUrlMappings("/hystrix.stream");
		servletRegistrationBean.setName("HystrixMetricsStreamServlet");
		return servletRegistrationBean;
	}

}
