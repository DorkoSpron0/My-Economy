package com.nicky.models;

import java.util.List;

public class UserDomain {

    private Long id;
    private String username;
    private String email;
    private String password;

    private List<AccountDomain> accounts;

    public UserDomain() {
    }

    public UserDomain(Long id, String username, String email, String password, List<AccountDomain> accounts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.accounts = accounts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<AccountDomain> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDomain> accounts) {
        this.accounts = accounts;
    }
}
