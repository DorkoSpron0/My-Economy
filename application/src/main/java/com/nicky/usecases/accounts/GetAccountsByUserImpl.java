package com.nicky.usecases.accounts;

import com.nicky.models.AccountDomain;
import com.nicky.ports.in.accounts.GetAccountsByUserUseCase;
import com.nicky.ports.out.AccountRepositoryPort;

import java.util.List;

public class GetAccountsByUserImpl implements GetAccountsByUserUseCase {

    private final AccountRepositoryPort accountRepository;

    public GetAccountsByUserImpl(AccountRepositoryPort accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<AccountDomain> getAccountsByUser(Long userId) {
        return accountRepository.findAll(userId);
    }
}
