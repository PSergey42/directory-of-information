package com.example.backend.mapper;

import com.example.backend.entity.ParticipantRestrictions;
import com.example.backend.entity.model.ParticipantRestrictionsPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParticipantRestrictionsMapper {
    ParticipantRestrictionsMapper INSTANCE = Mappers.getMapper(ParticipantRestrictionsMapper.class);
    ParticipantRestrictionsPojo fromEntity(ParticipantRestrictions participantRestrictions);
    ParticipantRestrictions toEntity(ParticipantRestrictionsPojo participantRestrictionsPojo);
}
