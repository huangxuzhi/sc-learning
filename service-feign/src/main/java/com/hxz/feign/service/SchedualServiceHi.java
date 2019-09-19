package com.hxz.feign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ~ @FeignClient作用：定义一个客户端，可以调用其他服务的接口
 *    value参数填写的是"需要调用的服务名"，fallback参数填写的是发生断路时要调用的类
 */

@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystrix.class)
public interface SchedualServiceHi {


    /**
     * ~ @RequestMapping的value跟调用接口路径一致，需要包括注解在类的@RequestMapping的value和注解在方法的@RequestMapping的value
     */
    @GetMapping(value = "service-hi/hi")
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
