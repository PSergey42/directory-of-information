package com.example.backend.entity.model;

import com.example.backend.entity.ParticipantInfo;
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
public class ParticipantInfoPojo {
    private long UID;
    private String nameParticipant;
    private String englishName;
    private String regN;
    private String countryCod;
    private String territoryCode;
    private String ind;
    private String typeLocality;
    private String nameLocality;
    private String adr;
    private int parentBIC;
    private Date dateIn;
    private String participantType;
    private String srvcs;
    private String xchType;
    private String participantStatus;
    private List<ParticipantRestrictionsPojo> participantRestrictionsPojo;

    public static ParticipantInfo toEntity(ParticipantInfoPojo participantInfoPojo) {
        ParticipantInfo participantInfo = new ParticipantInfo();
        if(participantInfoPojo.getParticipantRestrictionsPojo() != null)
            participantInfo.setParticipantRestrictions(participantInfoPojo.getParticipantRestrictionsPojo().stream().map(ParticipantRestrictionsPojo::toEntity).toList());
        try {
            BeanUtils.copyProperties(participantInfo, participantInfoPojo);
            if(participantInfo.getParticipantRestrictions() != null)
                participantInfo.getParticipantRestrictions().forEach(x -> x.setParticipantInfo(participantInfo));
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return participantInfo;
    }

    public static ParticipantInfoPojo fromEntity(ParticipantInfo participantInfo){
        ParticipantInfoPojo participantInfoPojo = new ParticipantInfoPojo();
        if(participantInfo.getParticipantRestrictions() != null)
            participantInfoPojo.setParticipantRestrictionsPojo(participantInfo.getParticipantRestrictions().stream().map(ParticipantRestrictionsPojo::fromEntity).toList());
        try {
            BeanUtils.copyProperties(participantInfoPojo, participantInfo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return participantInfoPojo;
    }
}
