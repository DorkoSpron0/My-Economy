package com.nicky.usecases.accounts;

import com.nicky.models.AccountDomain;
import com.nicky.ports.in.accounts.UpdateAccountUseCase;
import com.nicky.ports.out.AccountRepositoryPort;

public class UpdateAccountImpl implements UpdateAccountUseCase {

    private final AccountRepositoryPort accountRepository;

    public UpdateAccountImpl(AccountRepositoryPort accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDomain updateAccount(Long accountId, AccountDomain newAccount) {
        return accountRepository.update(accountId, newAccount);
    }
}
