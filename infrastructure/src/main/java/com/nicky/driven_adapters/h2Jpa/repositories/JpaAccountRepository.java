package com.nicky.driven_adapters.h2Jpa.repositories;

import com.nicky.driven_adapters.h2Jpa.dbo.AccountDBO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaAccountRepository extends JpaRepository<AccountDBO, Long> {
}
