package com.nicky.services;

import com.nicky.models.UserDomain;
import com.nicky.ports.in.users.LoginUserUseCase;
import com.nicky.ports.in.users.RegisterUserUseCase;

public class UserService implements RegisterUserUseCase, LoginUserUseCase {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUserUseCase loginUserUseCase;

    public UserService(RegisterUserUseCase registerUserUseCase, LoginUserUseCase loginUserUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.loginUserUseCase = loginUserUseCase;
    }

    @Override
    public String loginUser(UserDomain userDomain) {
        return loginUserUseCase.loginUser(userDomain);
    }

    @Override
    public UserDomain registerUser(UserDomain userDomain) {
        return registerUserUseCase.registerUser(userDomain);
    }
}
