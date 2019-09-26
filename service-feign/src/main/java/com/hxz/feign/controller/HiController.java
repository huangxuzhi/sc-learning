package com.hxz.feign.controller;

import com.hxz.feign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HiController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name);
    }

    @GetMapping("/dc")
    public String services() {
        String services = "services:" + discoveryClient.getServices();
        return services;
    }

    @GetMapping(value = "/hello")
    public String sayhello(@RequestParam String name) {
        return schedualServiceHi.hello(name);
    }
}
