package com.example.backend.service;

import com.example.backend.entity.BICDirectoryEntry;
import com.example.backend.entity.SWBIC;
import com.example.backend.entity.model.SWBICPojo;
import com.example.backend.repository.BICDirectoryEntryRepository;
import com.example.backend.repository.SWBICRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SWBICService {

    private final SWBICRepository swbicRepository;

    public SWBICService(SWBICRepository swbicRepository) {
        this.swbicRepository = swbicRepository;
    }

    public List<SWBICPojo> findAll(){
        return swbicRepository.findAll().stream().map(SWBICPojo::fromEntity).toList();
    }

    public SWBICPojo getSWBICByID(long id) {
        return swbicRepository.findById(id).map(SWBICPojo::fromEntity).orElse(null);
    }

    public SWBICPojo addSWBIC(SWBICPojo swbicPojo, long id) {
        BICDirectoryEntry bicDirectoryEntry = new BICDirectoryEntry();
        bicDirectoryEntry.setId(id);
        SWBIC swbic = SWBICPojo.toEntity(swbicPojo);
        swbic.setBicDirectoryEntry(bicDirectoryEntry);
        return SWBICPojo.fromEntity(swbicRepository.save(swbic));
    }

    public SWBICPojo updateSWBIC(SWBICPojo swbicPojo, long id) {
        return addSWBIC(swbicPojo, id);
    }

    public void deleteSWBIC(long id) {
        swbicRepository.deleteById(id);
    }
}
