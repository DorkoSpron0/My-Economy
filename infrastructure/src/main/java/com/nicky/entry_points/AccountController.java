package com.nicky.entry_points;

import com.nicky.models.AccountDomain;
import com.nicky.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<List<AccountDomain>> getAllAccounts(@PathVariable Long userId){
        return new ResponseEntity<>(accountService.getAccountsByUser(userId), HttpStatus.OK);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountDomain> getAccountById(@PathVariable Long accountId){
        return new ResponseEntity<>(accountService.getAccountById(accountId), HttpStatus.OK);
    }

    @PostMapping("/{accountId}")
    public ResponseEntity<AccountDomain> saveAccount(@RequestBody AccountDomain account, @PathVariable Long accountId){
        return new ResponseEntity<>(accountService.createAccount(accountId, account), HttpStatus.CREATED);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long accountId){
        return new ResponseEntity<>(accountService.deleteAccount(accountId), HttpStatus.OK);
    }
}
