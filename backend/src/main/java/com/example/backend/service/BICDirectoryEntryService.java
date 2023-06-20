package com.example.backend.service;

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
        return null;
    }

    public BICDirectoryEntryPojo getBICDirectoryEntryByBIC(int bic) {
        return null;
    }

    public BICDirectoryEntryPojo addBICDirectoryEntry(BICDirectoryEntryPojo bicDirectoryEntryPojo) {
        return null;
    }

    public BICDirectoryEntryPojo updateBICDirectoryEntry(BICDirectoryEntryPojo bicDirectoryEntryPojo) {
        return null;
    }

    public void deleteBICDirectoryEntry(int bic) {

    }
}
