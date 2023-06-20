package com.example.backend.service;

import com.example.backend.entity.model.AccountPojo;
import com.example.backend.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<AccountPojo> findAll() {
        return null;
    }

    public AccountPojo getAccountByNumber(String accountNumber) {
        return null;
    }

    public AccountPojo addAccount(AccountPojo accountPojo) {
        return null;
    }

    public AccountPojo updateAccount(AccountPojo accountPojo) {
        return null;
    }

    public void deleteAccount(String accountNumber) {

    }
}
