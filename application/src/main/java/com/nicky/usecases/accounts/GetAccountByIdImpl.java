package com.nicky.usecases.accounts;

import com.nicky.models.AccountDomain;
import com.nicky.ports.in.accounts.GetAccountByIdUseCase;
import com.nicky.ports.out.AccountRepositoryPort;

public class GetAccountByIdImpl implements GetAccountByIdUseCase {

    private final AccountRepositoryPort accountRepository;

    public GetAccountByIdImpl(AccountRepositoryPort accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDomain getAccountById(Long accountId) {
        return accountRepository.findById(accountId);
    }
}
