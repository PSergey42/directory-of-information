package com.example.backend.service;

import com.example.backend.entity.Account;
import com.example.backend.entity.AccountRestrictions;
import com.example.backend.entity.model.AccountRestrictionsPojo;
import com.example.backend.entity.model.SWBICPojo;
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

    public AccountRestrictionsPojo addAccountRestrictions(AccountRestrictionsPojo accountRestrictionsPojo, String accountNumber) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        AccountRestrictions accountRestrictions = AccountRestrictionsPojo.toEntity(accountRestrictionsPojo);
        accountRestrictions.setAccount(account);
        return AccountRestrictionsPojo.fromEntity(accountRestrictionsRepository.save(accountRestrictions));
    }

    public AccountRestrictionsPojo updateAccountRestrictions(AccountRestrictionsPojo accountRestrictionsPojo, String accountNumber) {
        return addAccountRestrictions(accountRestrictionsPojo, accountNumber);
    }

    public void deleteAccountRestrictions(long id) {
        accountRestrictionsRepository.deleteById(id);
    }
}
