package com.hxz.zipkin;

import brave.sampler.Sampler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ServiceHiApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceHiApplication.class);

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Sampler sampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

    @RequestMapping("hi")
    public String callHome() {
        LOGGER.info("calling trace service-hi");
        return restTemplate.getForObject("http://localhost:8989/miya", String.class);
    }

    @RequestMapping("info")
    public String info() {
        LOGGER.info("calling trace service-hi");
        return "I'm service hi.";
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceHiApplication.class, args);
    }




}
