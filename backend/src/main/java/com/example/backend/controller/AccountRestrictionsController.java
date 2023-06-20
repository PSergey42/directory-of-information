package com.example.backend.controller;

import com.example.backend.entity.model.AccountRestrictionsPojo;
import com.example.backend.service.AccountRestrictionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class AccountRestrictionsController {

    private final AccountRestrictionsService accountRestrictionsService;

    public AccountRestrictionsController(AccountRestrictionsService accountRestrictionsService) {
        this.accountRestrictionsService = accountRestrictionsService;
    }

    @GetMapping("/accountsRestrictions")
    public List<AccountRestrictionsPojo> findAll(){
        return accountRestrictionsService.findAll();
    }

    @GetMapping("/accountRestrictions/{accountNumber}")
    public AccountRestrictionsPojo getAccountRestrictionsByNumber(@PathVariable("accountNumber") String accountNumber) {
        return accountRestrictionsService.getAccountRestrictionsByNumber(accountNumber);
    }

    @PostMapping("/accountRestrictions")
    public AccountRestrictionsPojo addAccountRestrictions(@RequestBody AccountRestrictionsPojo accountRestrictionsPojo){
        return accountRestrictionsService.addAccountRestrictions(accountRestrictionsPojo);
    }

    @PutMapping("/accountRestrictions")
    public AccountRestrictionsPojo updateAccountRestrictions(@RequestBody AccountRestrictionsPojo accountRestrictionsPojo){
        return accountRestrictionsService.updateAccountRestrictions(accountRestrictionsPojo);
    }

    @DeleteMapping ("/accountRestrictions/{id}")
    public void deleteAccountRestrictions(@PathVariable("id") long id){
        accountRestrictionsService.deleteAccountRestrictions(id);
    }
}
