package com.example.backend.service;

import com.example.backend.entity.BICDirectoryEntry;
import com.example.backend.entity.EmailMessage;
import com.example.backend.entity.model.BICDirectoryEntryPojo;
import com.example.backend.repository.BICDirectoryEntryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BICDirectoryEntryService {

    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;

    public BICDirectoryEntryService(BICDirectoryEntryRepository bicDirectoryEntryRepository) {
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
    }

    public List<BICDirectoryEntryPojo> findAll() {
        return bicDirectoryEntryRepository.findAll().stream().map(BICDirectoryEntryPojo::fromEntity).toList();
    }

    public BICDirectoryEntryPojo getBICDirectoryEntryByBIC(long id) {
        return bicDirectoryEntryRepository.findById(id).map(BICDirectoryEntryPojo::fromEntity).orElse(null);
    }

    public BICDirectoryEntryPojo addBICDirectoryEntry(BICDirectoryEntryPojo bicDirectoryEntryPojo, long emailMessage_id) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setId(emailMessage_id);
        BICDirectoryEntry bicDirectoryEntry = BICDirectoryEntryPojo.toEntity(bicDirectoryEntryPojo);
        bicDirectoryEntry.setEmailMessage(emailMessage);
        return BICDirectoryEntryPojo.fromEntity(bicDirectoryEntryRepository.save(bicDirectoryEntry));
    }

    public BICDirectoryEntryPojo updateBICDirectoryEntry(BICDirectoryEntryPojo bicDirectoryEntryPojo, long emailMessage_id) {
        return addBICDirectoryEntry(bicDirectoryEntryPojo, emailMessage_id);
    }

    public void deleteBICDirectoryEntry(long id) {
        bicDirectoryEntryRepository.deleteById(id);
    }
}
