package com.nicky.ports.in.accounts;

import com.nicky.models.AccountDomain;

import java.util.List;

public interface GetAccountsByUserUseCase {
    List<AccountDomain> getAccountsByUser(Long userId);
}
