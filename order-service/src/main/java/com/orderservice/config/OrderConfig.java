package com.orderservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class OrderConfig {

    @Value("${application.config.product-url}")
    private String productUrl;

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
    @Bean
    public WebClient webClient(WebClient.Builder builder){

        if (productUrl == null || productUrl.isEmpty()){
            throw new IllegalArgumentException("Product URL must be defined in the configuration.");
        }
        return builder
                .baseUrl(productUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
