package com.hxz.feign;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableHystrixDashboard /*开启断路器监控功能*/
@EnableHystrix /*开启断路器功能*/
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients /* EnableFeignClients表示使用Feign客户端进行其他服务的调用 */
public class ServiceFeignApplication {



    public static void main(String[] args) {
        SpringApplication.run(ServiceFeignApplication.class, args);
    }
}
