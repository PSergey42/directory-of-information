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

    @GetMapping("/accountRestrictions/{id}")
    public AccountRestrictionsPojo getAccountRestrictionsByID(@PathVariable("id") long id) {
        return accountRestrictionsService.getAccountRestrictionsByNumber(id);
    }

    @PostMapping("/accountRestrictions/{accountNumber}")
    public AccountRestrictionsPojo addAccountRestrictions(@RequestBody AccountRestrictionsPojo accountRestrictionsPojo, @PathVariable("accountNumber") String accountNumber){
        return accountRestrictionsService.addAccountRestrictions(accountRestrictionsPojo, accountNumber);
    }

    @PutMapping("/accountRestrictions/{accountNumber}")
    public AccountRestrictionsPojo updateAccountRestrictions(@RequestBody AccountRestrictionsPojo accountRestrictionsPojo, @PathVariable("accountNumber") String accountNumber){
        return accountRestrictionsService.updateAccountRestrictions(accountRestrictionsPojo, accountNumber);
    }

    @DeleteMapping ("/accountRestrictions/{id}")
    public void deleteAccountRestrictions(@PathVariable("id") long id){
        accountRestrictionsService.deleteAccountRestrictions(id);
    }
}
