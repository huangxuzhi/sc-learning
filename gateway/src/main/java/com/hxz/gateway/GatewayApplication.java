package com.hxz.gateway;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        final String httpUri = "http://httpbin.org:80";
        return builder.routes()
                .route(p -> p
                    .path("/get") /* 匹配的路径  */
                    .filters(f -> f.addRequestHeader("Hello", "world")) /* 添加filter,可过滤请求或对请求作处理 */
                    .uri(httpUri)) /* 要跳转到哪个uri */
                .route(p -> p.host("*.hystrix.com") /* 当请求带有*.hystrix.com的Host请求头时，会进行路由 */
                        .filters(f -> f.hystrix(config -> config.setName("mycmd").setFallbackUri("forward:/fallback"))) /* 重定向到fallback接口 */
                        .uri(httpUri)) /* 要跳转到哪个uri */
                .build();
    }

    @RequestMapping("fallback")
    public Mono<String> fallback() {
        return Mono.just("fallback");
    }
}
