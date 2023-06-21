package com.example.backend.service;

import com.example.backend.entity.EmailMessage;
import com.example.backend.entity.model.BICDirectoryEntryPojo;
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
        return emailMessageRepository.findAll().stream().map(EmailMessagePojo::fromEntity).toList();
    }

    public EmailMessagePojo getEmailMessageByNumber(long id) {
        return emailMessageRepository.findById(id).map(EmailMessagePojo::fromEntity).orElse(null);
    }

    public EmailMessagePojo addEmailMessage(EmailMessagePojo emailMessagePojo) {
        return EmailMessagePojo.fromEntity(emailMessageRepository.save(EmailMessagePojo.toEntity(emailMessagePojo)));
    }

    public EmailMessagePojo updateEmailMessage(EmailMessagePojo emailMessagePojo) {
        return addEmailMessage(emailMessagePojo);
    }

    public void deleteEmailMessage(long id) {
        emailMessageRepository.deleteById(id);
    }
}
