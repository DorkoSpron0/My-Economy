package com.nicky.ports.in.accounts;

import com.nicky.models.AccountDomain;

public interface UpdateAccountUseCase {
    AccountDomain updateAccount(Long accountId, AccountDomain newAccount);
}
