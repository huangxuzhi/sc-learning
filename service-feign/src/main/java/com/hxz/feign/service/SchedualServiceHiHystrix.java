package com.hxz.feign.service;

import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystrix implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry," + name;
    }

    @Override
    public String hello(String name){
        return "sorry,"+name;
    }
}
