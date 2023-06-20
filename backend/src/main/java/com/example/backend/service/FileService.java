package com.example.backend.service;

import com.example.backend.entity.BICDirectoryEntry;
import com.example.backend.entity.EmailMessage;
import com.example.backend.entity.ParticipantInfo;
import com.example.backend.repository.BICDirectoryEntryRepository;
import com.example.backend.repository.EmailMessageRepository;
import com.example.backend.repository.ParticipantInfoRepository;
import com.example.backend.util.JaxbWorker;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class FileService {

    private final EmailMessageRepository emailMessageRepository;
    private final BICDirectoryEntryRepository bicDirectoryEntryRepository;
    private final ParticipantInfoRepository participantInfoRepository;

    public FileService(EmailMessageRepository emailMessageRepository, BICDirectoryEntryRepository bicDirectoryEntryRepository, ParticipantInfoRepository participantInfoRepository) {
        this.emailMessageRepository = emailMessageRepository;
        this.bicDirectoryEntryRepository = bicDirectoryEntryRepository;
        this.participantInfoRepository = participantInfoRepository;
    }

    //пока что сделано в лоб
    @Transactional
    public void saveXmlInDataBase(MultipartFile file){
        EmailMessage emailMessage = JaxbWorker.fromXmlToObject(file);
        emailMessageRepository.save(emailMessage);
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
            bicDirectoryEntryRepository.save(bicDirectoryEntry);
            participantInfoRepository.save(participantInfo);
        }
    }

}
