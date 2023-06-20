package com.example.backend.controller;

import com.example.backend.entity.model.AccountPojo;
import com.example.backend.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<AccountPojo> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/account/{accountNumber}")
    public AccountPojo getAccountByNumber(@PathVariable("accountNumber") String accountNumber) {
        return accountService.getAccountByNumber(accountNumber);
    }

    @PostMapping("/account")
    public AccountPojo addAccount(@RequestBody AccountPojo accountPojo){
        return accountService.addAccount(accountPojo);
    }

    @PutMapping("/account")
    public AccountPojo updateAccount(@RequestBody AccountPojo accountPojo){
        return accountService.updateAccount(accountPojo);
    }

    @DeleteMapping ("/account/{accountNumber}")
    public void deleteAccount(@PathVariable("accountNumber") String accountNumber){
        accountService.deleteAccount(accountNumber);
    }

}
