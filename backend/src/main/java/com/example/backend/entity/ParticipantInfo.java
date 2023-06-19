package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participantInfo")
public class ParticipantInfo {
    @Id
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
    private Date dateOut;
    private String participantType;
    private String srvcs;
    private String xchType;
    private String participantStatus;
    @OneToOne(mappedBy = "participantInfo")
    private BICDirectoryEntry bicDirectoryEntry;
    @OneToMany(mappedBy = "participantInfo", cascade = CascadeType.ALL)
    private List<ParticipantRestrictions> participantRestrictions;
}
