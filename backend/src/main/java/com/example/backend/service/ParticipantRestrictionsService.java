package com.example.backend.service;

import com.example.backend.entity.model.ParticipantRestrictionsPojo;
import com.example.backend.repository.ParticipantRestrictionsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantRestrictionsService {

    private final ParticipantRestrictionsRepository participantRestrictionsRepository;

    public ParticipantRestrictionsService(ParticipantRestrictionsRepository participantRestrictionsRepository) {
        this.participantRestrictionsRepository = participantRestrictionsRepository;
    }


    public List<ParticipantRestrictionsPojo> findAll() {
        return null;
    }

    public ParticipantRestrictionsPojo getParticipantRestrictionsByID(int id) {
        return null;
    }

    public ParticipantRestrictionsPojo addParticipantRestrictions(ParticipantRestrictionsPojo participantRestrictionsPojo) {
        return null;
    }

    public ParticipantRestrictionsPojo updateParticipantRestrictions(ParticipantRestrictionsPojo participantRestrictionsPojo) {
        return null;
    }

    public void deleteParticipantRestrictions(int id) {
    }
}
