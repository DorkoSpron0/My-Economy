package com.nicky.driven_adapters.h2Jpa.adapters;

import com.nicky.driven_adapters.h2Jpa.dbo.AccountDBO;
import com.nicky.driven_adapters.h2Jpa.dbo.UserDBO;
import com.nicky.driven_adapters.h2Jpa.repositories.JpaAccountRepository;
import com.nicky.driven_adapters.h2Jpa.repositories.JpaUserRepository;
import com.nicky.models.AccountDomain;
import com.nicky.ports.out.AccountRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final JpaAccountRepository accountRepository;
    private final JpaUserRepository userRepository;

    public AccountRepositoryAdapter(JpaAccountRepository accountRepository, JpaUserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public List<AccountDomain> findAll(Long userId) {
        return accountRepository.findAll().stream()
                .filter(accountDBO -> accountDBO.getUser().getId().equals(userId))
                .map(AccountDBO::toDomain)
                .toList();
    }

    @Override
    @Transactional
    public AccountDomain findById(Long accountId) {
        return accountRepository.findById(accountId)
                .map(AccountDBO::toDomain)
                .orElseThrow(() -> new NoSuchElementException("Account not found"));
    }

    @Override
    @Transactional
    public AccountDomain save(Long userId, AccountDomain account) {
        UserDBO userFounded = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException("user not found"));
        AccountDBO accountSaved = AccountDBO.fromDomain(account);

        accountSaved.setUser(userFounded);
        return accountRepository.save(accountSaved).toDomain();
    }

    @Override
    @Transactional
    public AccountDomain update(Long accountId, AccountDomain account) {
        return null;
    }

    @Override
    @Transactional
    public String remove(Long accountId) {
        accountRepository.delete(AccountDBO.fromDomain(findById(accountId)));
        return "Account with id" + accountId + " deleted successfully";
    }
}
