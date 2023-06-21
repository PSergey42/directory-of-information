package com.example.backend.entity.model;

import com.example.backend.entity.ParticipantRestrictions;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantRestrictionsPojo {
    private long id;
    private String rstr;
    private Date rstrDate;

    public static ParticipantRestrictions toEntity(ParticipantRestrictionsPojo participantRestrictionsPojo) {
        ParticipantRestrictions participantRestrictions = new ParticipantRestrictions();
        try {
            BeanUtils.copyProperties(participantRestrictions, participantRestrictionsPojo);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return participantRestrictions;
    }

    public static ParticipantRestrictionsPojo fromEntity(ParticipantRestrictions participantRestrictions){
        ParticipantRestrictionsPojo participantRestrictionsPojo = new ParticipantRestrictionsPojo();
        try {
            BeanUtils.copyProperties(participantRestrictionsPojo, participantRestrictions);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return participantRestrictionsPojo;
    }
}
