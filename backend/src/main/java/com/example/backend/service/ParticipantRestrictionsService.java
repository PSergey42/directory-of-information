package com.example.backend.service;
import com.example.backend.entity.ParticipantInfo;
import com.example.backend.entity.ParticipantRestrictions;
import com.example.backend.entity.model.AccountRestrictionsPojo;
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
        return participantRestrictionsRepository.findAll().stream().map(ParticipantRestrictionsPojo::fromEntity).toList();
    }

    public ParticipantRestrictionsPojo getParticipantRestrictionsByID(long id) {
        return participantRestrictionsRepository.findById(id).map(ParticipantRestrictionsPojo::fromEntity).orElse(null);
    }

    public ParticipantRestrictionsPojo addParticipantRestrictions(ParticipantRestrictionsPojo participantRestrictionsPojo, long uid) {
        ParticipantInfo participantInfo = new ParticipantInfo();
        participantInfo.setUID(uid);
        ParticipantRestrictions participantRestrictions = ParticipantRestrictionsPojo.toEntity(participantRestrictionsPojo);
        participantRestrictions.setParticipantInfo(participantInfo);
        return ParticipantRestrictionsPojo.fromEntity(participantRestrictionsRepository.save(participantRestrictions));
    }

    public ParticipantRestrictionsPojo updateParticipantRestrictions(ParticipantRestrictionsPojo participantRestrictionsPojo, long uid) {
        return addParticipantRestrictions(participantRestrictionsPojo, uid);
    }

    public void deleteParticipantRestrictions(long id) {
        participantRestrictionsRepository.deleteById(id);
    }
}
