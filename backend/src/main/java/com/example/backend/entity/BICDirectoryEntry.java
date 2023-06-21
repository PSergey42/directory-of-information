package com.example.backend.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bicDirectoryEntry")
@XmlAccessorType(XmlAccessType.FIELD)
public class BICDirectoryEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private long id;
    @XmlAttribute(name = "BIC")
    private int bic;
    @OneToOne(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    @XmlElement(name = "ParticipantInfo", namespace="urn:cbr-ru:ed:v2.0")
    private ParticipantInfo participantInfo;
    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    @XmlElement(name="SWBICS", namespace="urn:cbr-ru:ed:v2.0")
    private List<SWBIC> swBICs;
    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    @XmlElement(name="Accounts", namespace="urn:cbr-ru:ed:v2.0")
    private List<Account> accounts;
    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emailMessage_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private EmailMessage emailMessage;
}
