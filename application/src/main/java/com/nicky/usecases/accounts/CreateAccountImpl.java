package com.nicky.usecases.accounts;

import com.nicky.models.AccountDomain;
import com.nicky.ports.in.accounts.CreateAccountUseCase;
import com.nicky.ports.out.AccountRepositoryPort;

public class CreateAccountImpl implements CreateAccountUseCase {

    private final AccountRepositoryPort accountRepositoryPort;

    public CreateAccountImpl(AccountRepositoryPort accountRepositoryPort) {
        this.accountRepositoryPort = accountRepositoryPort;
    }

    @Override
    public AccountDomain createAccount(Long userId, AccountDomain account) {
        return accountRepositoryPort.save(userId, account);
    }
}
