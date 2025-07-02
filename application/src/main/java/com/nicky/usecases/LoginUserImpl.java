package com.nicky.usecases;

import com.nicky.models.UserDomain;
import com.nicky.ports.in.users.LoginUserUseCase;
import com.nicky.ports.out.UserRepositoryPort;

public class LoginUserImpl implements LoginUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public LoginUserImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public String loginUser(UserDomain userDomain) {
        return userRepositoryPort.login(userDomain);
    }
}
