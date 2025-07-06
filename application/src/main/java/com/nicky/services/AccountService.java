package com.nicky.services;

import com.nicky.models.AccountDomain;
import com.nicky.ports.in.accounts.*;

import java.util.List;

public class AccountService implements GetAccountsByUserUseCase, GetAccountByIdUseCase, CreateAccountUseCase, UpdateAccountUseCase, DeleteAccountUseCase {

    private final GetAccountsByUserUseCase getAccountsByUserUseCase;
    private final GetAccountByIdUseCase getAccountByIdUseCase;
    private final CreateAccountUseCase createAccountUseCase;
    private final UpdateAccountUseCase updateAccountUseCase;
    private final DeleteAccountUseCase deleteAccountUseCase;

    public AccountService(GetAccountsByUserUseCase getAccountsByUserUseCase, GetAccountByIdUseCase getAccountByIdUseCase, CreateAccountUseCase createAccountUseCase, UpdateAccountUseCase updateAccountUseCase, DeleteAccountUseCase deleteAccountUseCase) {
        this.getAccountsByUserUseCase = getAccountsByUserUseCase;
        this.getAccountByIdUseCase = getAccountByIdUseCase;
        this.createAccountUseCase = createAccountUseCase;
        this.updateAccountUseCase = updateAccountUseCase;
        this.deleteAccountUseCase = deleteAccountUseCase;
    }

    @Override
    public AccountDomain createAccount(Long userId, AccountDomain account) {
        return createAccountUseCase.createAccount(userId, account);
    }

    @Override
    public String deleteAccount(Long accountId) {
        return deleteAccountUseCase.deleteAccount(accountId);
    }

    @Override
    public AccountDomain getAccountById(Long accountId) {
        return getAccountByIdUseCase.getAccountById(accountId);
    }

    @Override
    public List<AccountDomain> getAccountsByUser(Long userId) {
        return getAccountsByUserUseCase.getAccountsByUser(userId);
    }

    @Override
    public AccountDomain updateAccount(Long accountId, AccountDomain newAccount) {
        return updateAccountUseCase.updateAccount(accountId, newAccount);
    }
}
