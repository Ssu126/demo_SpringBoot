package com.example.demo_SpringBoot.configuration;

import com.example.demo_SpringBoot.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService() {
        return new UserService();
    }
}
