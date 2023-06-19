package com.example.backend.service;

import com.example.backend.repository.ParticipantInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantInfoService {

    private final ParticipantInfoRepository participantInfoRepository;

    public ParticipantInfoService(ParticipantInfoRepository participantInfoRepository) {
        this.participantInfoRepository = participantInfoRepository;
    }
}
