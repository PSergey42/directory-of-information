package com.example.backend.mapper;

import com.example.backend.entity.EmailMessage;
import com.example.backend.entity.model.EmailMessagePojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmailMessageMapper {
    EmailMessageMapper INSTANCE = Mappers.getMapper(EmailMessageMapper.class);
    EmailMessagePojo fromEntity(EmailMessage emailMessage);
    EmailMessage toEntity(EmailMessagePojo emailMessage);
}
