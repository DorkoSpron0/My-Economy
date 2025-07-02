package com.nicky.driven_adapters.h2Jpa.repositories;

import com.nicky.driven_adapters.h2Jpa.dbo.UserDBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserDBO, Long> {
    Optional<UserDBO> findByEmail(String email);
}
