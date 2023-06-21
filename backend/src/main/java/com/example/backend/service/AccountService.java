package com.example.backend.service;

import com.example.backend.entity.Account;
import com.example.backend.entity.BICDirectoryEntry;
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
        return accountRepository.findAll().stream().map(AccountPojo::fromEntity).toList();
    }

    public AccountPojo getAccountByNumber(long id) {
        return accountRepository.findById(id).map(AccountPojo::fromEntity).orElse(null);
    }

    public AccountPojo addAccount(AccountPojo accountPojo, long id) {
        BICDirectoryEntry bicDirectoryEntry = new BICDirectoryEntry();
        bicDirectoryEntry.setId(id);
        Account account = AccountPojo.toEntity(accountPojo);
        account.setBicDirectoryEntry(bicDirectoryEntry);
        return AccountPojo.fromEntity(accountRepository.save(account));
    }

    public AccountPojo updateAccount(AccountPojo accountPojo, long id) {
        return addAccount(accountPojo, id);
    }

    public void deleteAccount(long id) {
        accountRepository.deleteById(id);
    }
}
