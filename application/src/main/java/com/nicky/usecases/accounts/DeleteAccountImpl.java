package com.nicky.usecases.accounts;

import com.nicky.ports.in.accounts.DeleteAccountUseCase;
import com.nicky.ports.out.AccountRepositoryPort;

public class DeleteAccountImpl implements DeleteAccountUseCase {

    private final AccountRepositoryPort accountRepository;

    public DeleteAccountImpl(AccountRepositoryPort accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public String deleteAccount(Long accountId) {
        return accountRepository.remove(accountId);
    }
}
