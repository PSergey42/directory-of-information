package com.example.backend.service;

import com.example.backend.repository.SWBICRepository;
import org.springframework.stereotype.Service;

@Service
public class SWBICService {

    private final SWBICRepository swbicRepository;

    public SWBICService(SWBICRepository swbicRepository) {
        this.swbicRepository = swbicRepository;
    }
}
