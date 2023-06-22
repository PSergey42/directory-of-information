package com.example.backend.controller;

import com.example.backend.entity.model.AccountPojo;
import com.example.backend.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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

    @GetMapping("/account/{id}")
    public AccountPojo getAccountByID(@PathVariable("id") long id) {
        return accountService.getAccountByNumber(id);
    }

    @PostMapping("/account/{id}")
    public AccountPojo addAccount(@RequestBody AccountPojo accountPojo, @PathVariable("id") long id){
        return accountService.addAccount(accountPojo, id);
    }

    @PutMapping("/account/{id}")
    public AccountPojo updateAccount(@RequestBody AccountPojo accountPojo, @PathVariable("id") long id){
        return accountService.updateAccount(accountPojo, id);
    }

    @DeleteMapping ("/account/{id}")
    public void deleteAccount(@PathVariable("id") long id){
        accountService.deleteAccount(id);
    }

}
