package com.example.backend.mapper;

import com.example.backend.entity.ParticipantInfo;
import com.example.backend.entity.model.ParticipantInfoPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParticipantInfoMapper {
    ParticipantInfoMapper INSTANCE = Mappers.getMapper(ParticipantInfoMapper.class);
    ParticipantInfoPojo fromEntity(ParticipantInfo participantInfo);
    ParticipantInfo toEntity(ParticipantInfoPojo participantInfoPojo);
}
