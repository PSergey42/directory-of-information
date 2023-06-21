package com.example.backend.entity.model;

import com.example.backend.entity.EmailMessage;
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
public class EmailMessagePojo {
    private long id;
    private int edNo;
    private long edAuthor;
    private Date edDate;
    private String creationReason;
    private Date creationDateTime;
    private String infoTypeCode;
    private Date businessDay;
    private int directoryVersion;
    private List<BICDirectoryEntryPojo> bicDirectoryEntryPojoList;

    public static EmailMessage toEntity(EmailMessagePojo emailMessagePojo) {
        EmailMessage emailMessage = new EmailMessage();
        if(emailMessagePojo.getBicDirectoryEntryPojoList() != null)
            emailMessage.setBicDirectoryEntryList(emailMessagePojo.getBicDirectoryEntryPojoList().stream().map(BICDirectoryEntryPojo::toEntity).toList());
        try {
            BeanUtils.copyProperties(emailMessage, emailMessagePojo);
            if(emailMessage.getBicDirectoryEntryList() != null)
                emailMessage.getBicDirectoryEntryList().forEach(x -> x.setEmailMessage(emailMessage));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return emailMessage;
    }

    public static EmailMessagePojo fromEntity(EmailMessage emailMessage){
        EmailMessagePojo emailMessagePojo = new EmailMessagePojo();
        if(emailMessage.getBicDirectoryEntryList() != null)
            emailMessagePojo.setBicDirectoryEntryPojoList(emailMessage.getBicDirectoryEntryList().stream().map(BICDirectoryEntryPojo::fromEntity).toList());
        try {
            BeanUtils.copyProperties(emailMessagePojo, emailMessage);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return emailMessagePojo;
    }
}
