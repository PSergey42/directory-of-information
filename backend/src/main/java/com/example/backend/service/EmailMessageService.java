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
        /*List<EmailMessage> list = List.of(new EmailMessage(1,2, new Date(), "ff", "fdd", new Date(), "", new Date(),
                List.of(new BICDirectoryEntry(23, 12))));
        return list.stream().map(EmailMessageMapper.INSTANCE::fromEntity).toList();*/
        return null;
    }
}
