package com.example.backend.service;

import com.example.backend.entity.model.SWBICPojo;
import com.example.backend.repository.SWBICRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SWBICService {

    private final SWBICRepository swbicRepository;

    public SWBICService(SWBICRepository swbicRepository) {
        this.swbicRepository = swbicRepository;
    }

    public List<SWBICPojo> findAll() {
        return null;
    }

    public SWBICPojo getSWBICByBIC(String bic) {
        return null;
    }

    public SWBICPojo addSWBIC(SWBICPojo swbicPojo) {
        return null;
    }

    public SWBICPojo updateSWBIC(SWBICPojo swbicPojo) {
        return null;
    }

    public void deleteSWBIC(String bic) {
    }
}
