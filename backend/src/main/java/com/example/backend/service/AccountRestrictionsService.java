package com.example.backend.service;

import com.example.backend.entity.Account;
import com.example.backend.entity.AccountRestrictions;
import com.example.backend.entity.model.AccountRestrictionsPojo;
import com.example.backend.repository.AccountRestrictionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountRestrictionsService {
    private final AccountRestrictionsRepository accountRestrictionsRepository;

    public AccountRestrictionsService(AccountRestrictionsRepository accountRestrictionsRepository) {
        this.accountRestrictionsRepository = accountRestrictionsRepository;
    }

    public List<AccountRestrictionsPojo> findAll() {
        return accountRestrictionsRepository.findAll().stream().map(AccountRestrictionsPojo::fromEntity).toList();
    }

    public AccountRestrictionsPojo getAccountRestrictionsByNumber(long id) {
        return accountRestrictionsRepository.findById(id).map(AccountRestrictionsPojo::fromEntity).orElse(null);
    }

    public AccountRestrictionsPojo addAccountRestrictions(AccountRestrictionsPojo accountRestrictionsPojo, long id) {
        Account account = new Account();
        account.setId(id);
        AccountRestrictions accountRestrictions = AccountRestrictionsPojo.toEntity(accountRestrictionsPojo);
        accountRestrictions.setAccount(account);
        return AccountRestrictionsPojo.fromEntity(accountRestrictionsRepository.save(accountRestrictions));
    }

    public AccountRestrictionsPojo updateAccountRestrictions(AccountRestrictionsPojo accountRestrictionsPojo, long id) {
        return addAccountRestrictions(accountRestrictionsPojo, id);
    }

    public void deleteAccountRestrictions(long id) {
        accountRestrictionsRepository.deleteById(id);
    }
}
