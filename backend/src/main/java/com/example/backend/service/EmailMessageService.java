package com.example.backend.service;

import com.example.backend.entity.model.EmailMessagePojo;
import com.example.backend.repository.EmailMessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailMessageService {

    private final EmailMessageRepository emailMessageRepository;

    public EmailMessageService(EmailMessageRepository emailMessageRepository) {
        this.emailMessageRepository = emailMessageRepository;
    }

    public List<EmailMessagePojo> findAll() {
        return null;
    }

    public EmailMessagePojo getEmailMessageByNumber(long number) {
        return null;
    }

    public EmailMessagePojo addEmailMessage(EmailMessagePojo emailMessagePojo) {
        return null;
    }

    public EmailMessagePojo updateEmailMessage(EmailMessagePojo emailMessagePojo) {
        return null;
    }

    public void deleteEmailMessage(long number) {
    }
}
