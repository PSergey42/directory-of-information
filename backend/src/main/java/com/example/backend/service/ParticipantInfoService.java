package com.example.backend.service;

import com.example.backend.entity.BICDirectoryEntry;
import com.example.backend.entity.ParticipantInfo;
import com.example.backend.entity.model.ParticipantInfoPojo;
import com.example.backend.repository.ParticipantInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantInfoService {

    private final ParticipantInfoRepository participantInfoRepository;

    public ParticipantInfoService(ParticipantInfoRepository participantInfoRepository) {
        this.participantInfoRepository = participantInfoRepository;
    }

    public List<ParticipantInfoPojo> findAll() {
        return participantInfoRepository.findAll().stream().map(ParticipantInfoPojo::fromEntity).toList();
    }

    public ParticipantInfoPojo getParticipantInfoByUID(long uid) {
        return participantInfoRepository.findById(uid).map(ParticipantInfoPojo::fromEntity).orElse(null);
    }

    public ParticipantInfoPojo addParticipantInfo(ParticipantInfoPojo participantInfoPojo, int bic) {
        BICDirectoryEntry bicDirectoryEntry = new BICDirectoryEntry();
        bicDirectoryEntry.setBic(bic);
        ParticipantInfo participantInfo = ParticipantInfoPojo.toEntity(participantInfoPojo);
        participantInfo.setBicDirectoryEntry(bicDirectoryEntry);
        return ParticipantInfoPojo.fromEntity(participantInfoRepository.save(participantInfo));
    }

    public ParticipantInfoPojo updateParticipantInfo(ParticipantInfoPojo participantInfoPojo, int bic) {
        return addParticipantInfo(participantInfoPojo, bic);
    }

    public void deleteParticipantInfo(long uid) {
        participantInfoRepository.deleteById(uid);
    }
}
