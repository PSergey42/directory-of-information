package com.example.backend.service;

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
        return null;
    }

    public ParticipantInfoPojo getParticipantInfoByUID(long uid) {
        return null;
    }

    public ParticipantInfoPojo addParticipantInfo(ParticipantInfoPojo participantInfoPojo) {
        return null;
    }

    public ParticipantInfoPojo updateParticipantInfo(ParticipantInfoPojo participantInfoPojo) {
        return null;
    }

    public void deleteParticipantInfo(long uid) {
    }
}
