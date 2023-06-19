package com.example.backend.controller;

import com.example.backend.service.AccountRestrictionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class AccountRestrictionsController {

    private final AccountRestrictionsService accountRestrictionsService;

    public AccountRestrictionsController(AccountRestrictionsService accountRestrictionsService) {
        this.accountRestrictionsService = accountRestrictionsService;
    }
}
