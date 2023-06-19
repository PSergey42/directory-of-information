package com.example.backend.service;

import com.example.backend.repository.AccountRestrictionsRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountRestrictionsService {
    private final AccountRestrictionsRepository accountRestrictionsRepository;

    public AccountRestrictionsService(AccountRestrictionsRepository accountRestrictionsRepository) {
        this.accountRestrictionsRepository = accountRestrictionsRepository;
    }
}
