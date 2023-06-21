package com.example.backend.entity.model;

import com.example.backend.entity.AccountRestrictions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountRestrictionsPojo {
    private long id;
    private String accRSTR;
    private Date accRSTRDate;

    public static AccountRestrictions toEntity(AccountRestrictionsPojo accountRestrictionsPojo) {
        AccountRestrictions accountRestrictions = new AccountRestrictions();
        try {
            BeanUtils.copyProperties(accountRestrictions, accountRestrictionsPojo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return accountRestrictions;
    }

    public static AccountRestrictionsPojo fromEntity(AccountRestrictions accountRestrictions){
        AccountRestrictionsPojo accountRestrictionsPojo = new AccountRestrictionsPojo();
        try {
            BeanUtils.copyProperties(accountRestrictionsPojo, accountRestrictions);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return accountRestrictionsPojo;
    }
}
