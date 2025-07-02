package com.nicky.driven_adapters.h2Jpa.dbo;

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
@Table(name = "user_TABLE")
public class UserDBO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;

    public static UserDBO fromDomain(UserDomain userDomain){
        return UserDBO
                .builder()
                .id(userDomain.getId())
                .username(userDomain.getUsername())
                .email(userDomain.getEmail())
                .password(userDomain.getPassword())
                .build();
    }

    public UserDomain toDomain(){
        return new UserDomain(
                getId(),
                getUsername(),
                getEmail(),
                getPassword()
        );
    }
}
