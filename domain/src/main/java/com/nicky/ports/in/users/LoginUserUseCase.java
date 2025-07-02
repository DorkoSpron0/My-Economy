package com.nicky.ports.in.users;

import com.nicky.models.UserDomain;

public interface LoginUserUseCase {
    String loginUser(UserDomain userDomain);
}
