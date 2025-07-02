package com.nicky.config.beans;

import com.nicky.driven_adapters.h2Jpa.adapters.UserRepositoryAdapter;
import com.nicky.ports.out.UserRepositoryPort;
import com.nicky.services.UserService;
import com.nicky.usecases.LoginUserImpl;
import com.nicky.usecases.RegisterUserImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort){
        return new UserService(
                new RegisterUserImpl(userRepositoryPort),
                new LoginUserImpl(userRepositoryPort)
        );
    }

    @Bean
    public UserRepositoryPort userRepositoryPort(UserRepositoryAdapter userRepositoryAdapter){
        return userRepositoryAdapter;
    }
}
