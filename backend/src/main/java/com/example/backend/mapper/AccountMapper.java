package com.example.backend.mapper;

import com.example.backend.entity.Account;
import com.example.backend.entity.model.AccountPojo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    AccountPojo fromEntity(Account account);
    Account toEntity(AccountPojo accountPojo);
}
