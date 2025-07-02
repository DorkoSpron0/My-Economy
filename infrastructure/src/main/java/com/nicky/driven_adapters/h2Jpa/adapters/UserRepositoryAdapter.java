package com.nicky.driven_adapters.h2Jpa.adapters;

import com.nicky.driven_adapters.h2Jpa.dbo.UserDBO;
import com.nicky.driven_adapters.h2Jpa.repositories.JpaUserRepository;
import com.nicky.models.UserDomain;
import com.nicky.ports.out.UserRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final JpaUserRepository userRepository;

    public UserRepositoryAdapter(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional
    public UserDomain save(UserDomain userDomain) {
        return userRepository.save(UserDBO.fromDomain(userDomain)).toDomain();
    }

    @Override
    @Transactional
    public String login(UserDomain user) {
        UserDBO userFounded = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        return "jwt";
    }
}
