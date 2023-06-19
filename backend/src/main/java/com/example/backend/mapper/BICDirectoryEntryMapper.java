package com.example.backend.mapper;


import com.example.backend.entity.BICDirectoryEntry;
import com.example.backend.entity.model.BICDirectoryEntryPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BICDirectoryEntryMapper {
    BICDirectoryEntryMapper INSTANCE = Mappers.getMapper(BICDirectoryEntryMapper.class);
    BICDirectoryEntryPojo fromEntity(BICDirectoryEntry bicDirectoryEntry);
    BICDirectoryEntry toEntity(BICDirectoryEntryPojo bicDirectoryEntryPojo);
}
