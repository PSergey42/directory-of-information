package com.example.backend.service;

import com.example.backend.repository.ParticipantRestrictionsRepository;
import org.springframework.stereotype.Service;

@Service
public class ParticipantRestrictionsService {

    private final ParticipantRestrictionsRepository participantRestrictionsRepository;

    public ParticipantRestrictionsService(ParticipantRestrictionsRepository participantRestrictionsRepository) {
        this.participantRestrictionsRepository = participantRestrictionsRepository;
    }
}
