package com.nicky.usecases;

import com.nicky.models.UserDomain;
import com.nicky.ports.in.users.RegisterUserUseCase;
import com.nicky.ports.out.UserRepositoryPort;

public class RegisterUserImpl implements RegisterUserUseCase {

    private final UserRepositoryPort userRepositoryPort;

    public RegisterUserImpl(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserDomain registerUser(UserDomain userDomain) {
        if(userDomain.getUsername() == null || userDomain.getEmail() == null || userDomain.getPassword() == null){
            throw new IllegalArgumentException("Invalid credentials");
        }

        return userRepositoryPort.save(userDomain);
    }
}
