package com.nicky.ports.in.accounts;

import com.nicky.models.AccountDomain;

public interface CreateAccountUseCase {
    AccountDomain createAccount(Long userId, AccountDomain account);
}
