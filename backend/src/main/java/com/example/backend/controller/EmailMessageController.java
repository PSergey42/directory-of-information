package com.example.backend.controller;

import com.example.backend.entity.model.EmailMessagePojo;
import com.example.backend.service.EmailMessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmailMessageController {

    private final EmailMessageService emailMessageService;

    public EmailMessageController(EmailMessageService emailMessageService) {
        this.emailMessageService = emailMessageService;
    }

    @GetMapping
    public List<EmailMessagePojo> findAll(){
        return emailMessageService.findAll();
    }
}
