package com.example.backend.entity.model;

import com.example.backend.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountPojo {
    private long id;
    private String accountNumber;
    private String regulationAccountType;
    private String controlKey;
    private int accountCBRBIC;
    private Date dateIn;
    private String accountStatus;
    private List<AccountRestrictionsPojo> accountRestrictionsPojo;

    public static Account toEntity(AccountPojo accountPojo) {
        Account account = new Account();
        if(accountPojo.getAccountRestrictionsPojo() != null)
            account.setAccountRestrictions(accountPojo.getAccountRestrictionsPojo().stream().map(AccountRestrictionsPojo::toEntity).toList());
        try {
            BeanUtils.copyProperties(account, accountPojo);
            if(account.getAccountRestrictions() != null)
                account.getAccountRestrictions().forEach(x -> x.setAccount(account));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    public static AccountPojo fromEntity(Account account){
        AccountPojo accountPojo = new AccountPojo();
        if(account.getAccountRestrictions() != null)
            accountPojo.setAccountRestrictionsPojo(account.getAccountRestrictions().stream().map(AccountRestrictionsPojo::fromEntity).toList());
        try {
            BeanUtils.copyProperties(accountPojo, account);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return accountPojo;
    }
}
