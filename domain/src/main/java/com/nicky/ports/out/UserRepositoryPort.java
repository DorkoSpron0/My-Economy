package com.nicky.ports.out;

import com.nicky.models.UserDomain;

public interface UserRepositoryPort {
    UserDomain save(UserDomain userDomain);
    String login(UserDomain userDomain);
}
