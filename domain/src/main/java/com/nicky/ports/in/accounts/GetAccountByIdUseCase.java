package com.nicky.ports.in.accounts;

import com.nicky.models.AccountDomain;

public interface GetAccountByIdUseCase {
    AccountDomain getAccountById(Long accountId);
}
