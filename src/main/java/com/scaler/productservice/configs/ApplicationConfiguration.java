package com.scaler.productservice.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {


    RestTemplate restTemplate;

    @Bean
    public RestTemplate createRestTemplate(){
      return  new RestTemplate();
    }
}
