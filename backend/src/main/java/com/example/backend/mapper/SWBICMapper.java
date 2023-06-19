package com.example.backend.mapper;

import com.example.backend.entity.SWBIC;
import com.example.backend.entity.model.SWBICPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SWBICMapper {
    SWBICMapper INSTANCE = Mappers.getMapper(SWBICMapper.class);
    SWBICPojo fromEntity(SWBIC swbic);
    SWBIC toEntity(SWBICPojo swbicPojo);
}
