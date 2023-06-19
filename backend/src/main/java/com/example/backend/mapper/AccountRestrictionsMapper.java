package com.example.backend.mapper;

import com.example.backend.entity.AccountRestrictions;
import com.example.backend.entity.model.AccountRestrictionsPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountRestrictionsMapper {
    AccountRestrictionsMapper INSTANCE = Mappers.getMapper(AccountRestrictionsMapper.class);
    AccountRestrictionsPojo fromEntity(AccountRestrictions accountRestrictions);
    AccountRestrictions toEntity(AccountRestrictionsPojo accountRestrictionsPojo);
}
