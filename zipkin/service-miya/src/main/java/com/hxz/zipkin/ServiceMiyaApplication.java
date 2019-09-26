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

@RestController
@SpringBootApplication
public class ServiceMiyaApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMiyaApplication.class);

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
        LOGGER.info("hi is being called");
        return "Hi I'm miya!";
    }

    @RequestMapping("miya")
    public String info() {
        LOGGER.info("info is being called");
        return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceMiyaApplication.class, args);
    }
}
