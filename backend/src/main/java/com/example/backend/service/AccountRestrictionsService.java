package com.example.backend.service;

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
        return null;
    }

    public AccountRestrictionsPojo getAccountRestrictionsByNumber(String accountNumber) {
        return null;
    }

    public AccountRestrictionsPojo addAccountRestrictions(AccountRestrictionsPojo accountRestrictionsPojo) {
        return null;
    }

    public AccountRestrictionsPojo updateAccountRestrictions(AccountRestrictionsPojo accountRestrictionsPojo) {
        return null;
    }

    public void deleteAccountRestrictions(long id) {
    }
}
