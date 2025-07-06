package com.nicky.driven_adapters.h2Jpa.dbo;

import com.nicky.models.AccountDomain;
import com.nicky.models.AccountType;
import com.nicky.models.UserDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "account_TABLE")
public class AccountDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private String accountNumber;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "userId")
    private UserDBO user;

    public static AccountDBO fromDomain(AccountDomain domain){
        AccountDBO account = AccountDBO.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .description(domain.getDescription())
                .accountType(domain.getAccountType())
                .accountNumber(domain.getAccountNumber())
                .build();

        if(domain.getUser() != null){
            account.user = new UserDBO(
                    domain.getUser().getId(),
                    domain.getUser().getUsername(),
                    domain.getUser().getEmail(),
                    domain.getUser().getPassword(),
                    null
            );
        }

        return account;
    }

    public AccountDomain toDomain(){
        return new AccountDomain(
                getId(),
                getTitle(),
                getDescription(),
                getAccountType(),
                getAccountNumber(),
                getUser() != null ? new UserDomain(
                        getUser().getId(),
                        getUser().getUsername(),
                        getUser().getEmail(),
                        getUser().getPassword(),
                        null
                ) : null
        );
    }
}
