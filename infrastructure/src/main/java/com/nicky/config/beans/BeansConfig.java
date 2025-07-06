package com.nicky.config.beans;

import com.nicky.driven_adapters.h2Jpa.adapters.AccountRepositoryAdapter;
import com.nicky.driven_adapters.h2Jpa.adapters.UserRepositoryAdapter;
import com.nicky.ports.out.AccountRepositoryPort;
import com.nicky.ports.out.UserRepositoryPort;
import com.nicky.services.AccountService;
import com.nicky.services.UserService;
import com.nicky.usecases.accounts.*;
import com.nicky.usecases.user.LoginUserImpl;
import com.nicky.usecases.user.RegisterUserImpl;
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

    @Bean
    public AccountService accountService(AccountRepositoryPort accountRepositoryPort){
        return new AccountService(
                new GetAccountsByUserImpl(accountRepositoryPort),
                new GetAccountByIdImpl(accountRepositoryPort),
                new CreateAccountImpl(accountRepositoryPort),
                new UpdateAccountImpl(accountRepositoryPort),
                new DeleteAccountImpl(accountRepositoryPort)
        );
    }

    @Bean
    public AccountRepositoryPort accountRepositoryPort(AccountRepositoryAdapter adapter){
        return adapter;
    }
}
