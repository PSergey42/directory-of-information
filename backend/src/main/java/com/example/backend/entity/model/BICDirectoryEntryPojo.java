package com.example.backend.entity.model;

import com.example.backend.entity.BICDirectoryEntry;
import com.example.backend.entity.ParticipantInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BICDirectoryEntryPojo {
    private long id;
    private int bic;
    private ParticipantInfoPojo participantInfoPojo;
    private List<SWBICPojo> swBICPojoList;
    private List<AccountPojo> accountPojoList;

    public static BICDirectoryEntry toEntity(BICDirectoryEntryPojo bicDirectoryEntryPojo) {
        BICDirectoryEntry bicDirectoryEntry = new BICDirectoryEntry();
        bicDirectoryEntry.setParticipantInfo(ParticipantInfoPojo.toEntity(bicDirectoryEntryPojo.getParticipantInfoPojo()));
        if(bicDirectoryEntryPojo.getSwBICPojoList() != null)
            bicDirectoryEntry.setSwBICs(bicDirectoryEntryPojo.getSwBICPojoList().stream().map(SWBICPojo::toEntity).toList());
        if(bicDirectoryEntryPojo.getAccountPojoList() != null)
            bicDirectoryEntry.setAccounts(bicDirectoryEntryPojo.getAccountPojoList().stream().map(AccountPojo::toEntity).toList());
        try {
            BeanUtils.copyProperties(bicDirectoryEntry, bicDirectoryEntryPojo);
            bicDirectoryEntry.getParticipantInfo().setBicDirectoryEntry(bicDirectoryEntry);
            if(bicDirectoryEntry.getAccounts() != null)
                bicDirectoryEntry.getAccounts().forEach(x -> x.setBicDirectoryEntry(bicDirectoryEntry));
            if(bicDirectoryEntry.getSwBICs() != null)
                bicDirectoryEntry.getSwBICs().forEach(x -> x.setBicDirectoryEntry(bicDirectoryEntry));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return bicDirectoryEntry;
    }

    public static BICDirectoryEntryPojo fromEntity(BICDirectoryEntry bicDirectoryEntry){
        BICDirectoryEntryPojo bicDirectoryEntryPojo = new BICDirectoryEntryPojo();
        bicDirectoryEntryPojo.setParticipantInfoPojo(ParticipantInfoPojo.fromEntity(bicDirectoryEntry.getParticipantInfo()));
        if(bicDirectoryEntry.getSwBICs() != null)
            bicDirectoryEntryPojo.setSwBICPojoList(bicDirectoryEntry.getSwBICs().stream().map(SWBICPojo::fromEntity).toList());
        if(bicDirectoryEntry.getAccounts() != null)
            bicDirectoryEntryPojo.setAccountPojoList(bicDirectoryEntry.getAccounts().stream().map(AccountPojo::fromEntity).toList());
        try {
            BeanUtils.copyProperties(bicDirectoryEntryPojo, bicDirectoryEntry);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return bicDirectoryEntryPojo;
    }
}
