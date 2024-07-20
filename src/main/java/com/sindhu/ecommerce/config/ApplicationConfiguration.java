package com.sindhu.ecommerce.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {

    @Bean
     public RestTemplate heyThere(){
       return new RestTemplate();
    }
//    @Bean
//    public RestTemplate getRestTemplateBean(){
//        int noOfRequests = 100;
//        int timeout=1;
//        boolean shouldAuthentucated = false;
//        return new RestTemplate(noOfRequests, timeout, shouldAuthentucated);

}
