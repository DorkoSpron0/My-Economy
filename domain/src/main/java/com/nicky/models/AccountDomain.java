package com.nicky.models;

public class AccountDomain {

    private Long id;
    private String title;
    private String description;
    private AccountType accountType;
    private String accountNumber;

    private UserDomain user;

    public AccountDomain() {
    }

    public AccountDomain(Long id, String title, String description, AccountType accountType, String accountNumber, UserDomain user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public UserDomain getUser() {
        return user;
    }

    public void setUser(UserDomain user) {
        this.user = user;
    }
}
