package com.nicky.ports.in.users;

import com.nicky.models.UserDomain;

public interface RegisterUserUseCase {
    UserDomain registerUser(UserDomain userDomain);
}
