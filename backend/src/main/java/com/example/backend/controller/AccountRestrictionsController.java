package com.example.backend.controller;

import com.example.backend.entity.model.AccountRestrictionsPojo;
import com.example.backend.service.AccountRestrictionsService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Log4j2
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

    @PostMapping("/accountRestrictions/{id}")
    public AccountRestrictionsPojo addAccountRestrictions(@RequestBody AccountRestrictionsPojo accountRestrictionsPojo, @PathVariable("id") long id){
        return accountRestrictionsService.addAccountRestrictions(accountRestrictionsPojo, id);
    }

    @PutMapping("/accountRestrictions/{id}")
    public AccountRestrictionsPojo updateAccountRestrictions(@RequestBody AccountRestrictionsPojo accountRestrictionsPojo, @PathVariable("id") long id){
        return accountRestrictionsService.updateAccountRestrictions(accountRestrictionsPojo, id);
    }

    @DeleteMapping ("/accountRestrictions/{id}")
    public void deleteAccountRestrictions(@PathVariable("id") long id){
        accountRestrictionsService.deleteAccountRestrictions(id);
    }
}
