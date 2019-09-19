package com.hxz.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * EnableEurekaClient注解表示是一个服务提供方，会注册服务到注册中心，注册中心是eureka。
 * EnableDiscoveryClient注解跟EnableEurekaClient注解差不多，也用于服务发现，但是使用这个注解的注册中心可能是eureka、consul、zookeeper。
 * EnableHystrix注解表示开启熔断功能。
 */
@EnableEurekaClient
@EnableDiscoveryClient
@EnableHystrix
@SpringBootApplication
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}

	/**
	 *  RestTemplate可以用来调用调用其他服务。
	 *  LoadBalanced注解则开启负载均衡功能。
	 */
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
