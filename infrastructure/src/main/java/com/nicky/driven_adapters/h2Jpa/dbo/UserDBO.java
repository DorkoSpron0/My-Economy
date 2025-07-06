package com.nicky.driven_adapters.h2Jpa.dbo;

import com.nicky.models.AccountDomain;
import com.nicky.models.UserDomain;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "user_TABLE")
public class UserDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user")
    private List<AccountDBO> accounts;

    public static UserDBO fromDomain(UserDomain userDomain){
        UserDBO user = UserDBO
                .builder()
                .id(userDomain.getId())
                .username(userDomain.getUsername())
                .email(userDomain.getEmail())
                .password(userDomain.getPassword())
                .build();

        if(userDomain.getAccounts() != null){
            user.accounts = userDomain.getAccounts().stream()
                    .map(accountDomain -> new AccountDBO(
                            accountDomain.getId(),
                            accountDomain.getTitle(),
                            accountDomain.getDescription(),
                            accountDomain.getAccountType(),
                            accountDomain.getAccountNumber(),
                            null
                    )).toList();
        }

        return user;
    }

    public UserDomain toDomain(){
        return new UserDomain(
                getId(),
                getUsername(),
                getEmail(),
                getPassword(),
                getAccounts() != null ? getAccounts().stream()
                        .map(accountDBO -> new AccountDomain(
                                accountDBO.getId(),
                                accountDBO.getTitle(),
                                accountDBO.getDescription(),
                                accountDBO.getAccountType(),
                                accountDBO.getAccountNumber(),
                                null
                        )).toList() : null
        );
    }
}
