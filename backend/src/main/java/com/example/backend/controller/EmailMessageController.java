package com.example.backend.controller;

import com.example.backend.entity.model.BICDirectoryEntryPojo;
import com.example.backend.entity.model.EmailMessagePojo;
import com.example.backend.service.EmailMessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emailMessage")
public class EmailMessageController {

    private final EmailMessageService emailMessageService;

    public EmailMessageController(EmailMessageService emailMessageService) {
        this.emailMessageService = emailMessageService;
    }

    @GetMapping("/all")
    public List<EmailMessagePojo> findAll(){
        return emailMessageService.findAll();
    }

    @GetMapping("/{id}")
    public EmailMessagePojo getEmailMessageByNumber(@PathVariable("id") long id) {
        return emailMessageService.getEmailMessageByNumber(id);
    }

    @PostMapping
    public EmailMessagePojo addEmailMessage(@RequestBody EmailMessagePojo emailMessagePojo){
        return emailMessageService.addEmailMessage(emailMessagePojo);
    }

    @PutMapping
    public EmailMessagePojo updateEmailMessage(@RequestBody EmailMessagePojo emailMessagePojo){
        return emailMessageService.updateEmailMessage(emailMessagePojo);
    }

    @DeleteMapping ("/{id}")
    public void deleteEmailMessage(@PathVariable("id") long id){
        emailMessageService.deleteEmailMessage(id);
    }
}
