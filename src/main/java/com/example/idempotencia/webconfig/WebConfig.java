package com.example.idempotencia.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(transactionIdRequestInterceptor());
    }

    @Bean
    @RequestScope
    public RequestTransaction requestTransaction() {
        System.out.println("Novo");
        return new RequestTransaction();
    }

    @Bean
    @RequestScope
    public TransactionIdInterceptor transactionIdRequestInterceptor() {
        return new TransactionIdInterceptor(requestTransaction());
    }

}
