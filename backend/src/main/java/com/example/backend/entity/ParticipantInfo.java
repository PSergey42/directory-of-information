package com.example.backend.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
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
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantInfo {
    @Id
    @XmlAttribute(name = "UID")
    private long UID;
    @XmlAttribute(name = "NameP")
    private String nameParticipant;
    @XmlAttribute(name = "EnglName")
    private String englishName;
    @XmlAttribute(name = "RegN")
    private String regN;
    @XmlAttribute(name = "CntrCd")
    private String countryCod;
    @XmlAttribute(name = "Rgn")
    private String territoryCode;
    @XmlAttribute(name = "Ind")
    private String ind;
    @XmlAttribute(name = "Tnp")
    private String typeLocality;
    @XmlAttribute(name = "Nnp")
    private String nameLocality;
    @XmlAttribute(name = "Adr")
    private String adr;
    @XmlAttribute(name = "PrntBIC")
    private int parentBIC;
    @Temporal(TemporalType.DATE)
    @XmlAttribute(name = "DateIn")
    private Date dateIn;
    @XmlAttribute(name = "PtType")
    private String participantType;
    @XmlAttribute(name = "Srvcs")
    private String srvcs;
    @XmlAttribute(name = "XchType")
    private String xchType;
    @XmlAttribute(name = "ParticipantStatus")
    private String participantStatus;
    @XmlTransient
    @OneToOne()
    @JoinColumn(name = "bicDirectoryEntry_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private BICDirectoryEntry bicDirectoryEntry;
    @OneToMany(mappedBy = "participantInfo", cascade = CascadeType.ALL)
    @XmlElement(name = "RstrList", namespace="urn:cbr-ru:ed:v2.0")
    private List<ParticipantRestrictions> participantRestrictions;
}
