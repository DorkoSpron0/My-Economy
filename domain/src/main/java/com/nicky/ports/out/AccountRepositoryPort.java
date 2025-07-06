package com.nicky.ports.out;

import com.nicky.models.AccountDomain;

import java.util.List;

public interface AccountRepositoryPort {
    List<AccountDomain> findAll(Long userId);
    AccountDomain findById(Long accountId);
    AccountDomain save(Long userId, AccountDomain account);
    AccountDomain update(Long accountId, AccountDomain account);
    String remove(Long accountId);
}
