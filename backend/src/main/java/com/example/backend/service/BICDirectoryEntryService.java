package com.example.backend.service;

import com.example.backend.repository.BICDirectoryEntryRepository;
import org.springframework.stereotype.Service;

@Service
public class BICDirectoryEntryService {

    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;

    public BICDirectoryEntryService(BICDirectoryEntryRepository bicDirectoryEntryRepository) {
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
    }
}
