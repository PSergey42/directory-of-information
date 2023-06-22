package com.example.backend.service;

import com.example.backend.entity.BICDirectoryEntry;
import com.example.backend.entity.EmailMessage;
import com.example.backend.entity.ParticipantInfo;
import com.example.backend.repository.EmailMessageRepository;
import com.example.backend.util.JaxbWorker;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileService {

    private final EmailMessageRepository emailMessageRepository;

    public FileService(EmailMessageRepository emailMessageRepository) {
        this.emailMessageRepository = emailMessageRepository;
    }

    //пока что сделано в лоб
    @Transactional
    public void saveXmlInDataBase(MultipartFile file){
        EmailMessage emailMessage = JaxbWorker.fromXmlToObject(file);
        if(emailMessage.getBicDirectoryEntryList() != null){
            emailMessage.getBicDirectoryEntryList().forEach(x -> x.setEmailMessage(emailMessage));
            for (BICDirectoryEntry bicDirectoryEntry: emailMessage.getBicDirectoryEntryList()) {
                ParticipantInfo participantInfo = bicDirectoryEntry.getParticipantInfo();
                participantInfo.setBicDirectoryEntry(bicDirectoryEntry);
                if(participantInfo.getParticipantRestrictions() != null)
                    participantInfo.getParticipantRestrictions().forEach(x -> x.setParticipantInfo(participantInfo));
                if(bicDirectoryEntry.getSwBICs() != null)
                    bicDirectoryEntry.getSwBICs().forEach(x -> x.setBicDirectoryEntry(bicDirectoryEntry));
                if(bicDirectoryEntry.getAccounts() != null)
                    bicDirectoryEntry.getAccounts().forEach(x -> {
                        x.setBicDirectoryEntry(bicDirectoryEntry);
                        if(x.getAccountRestrictions() != null)
                            x.getAccountRestrictions().forEach(y -> y.setAccount(x));
                    });
            }
        }
        emailMessageRepository.save(emailMessage);
    }

}
