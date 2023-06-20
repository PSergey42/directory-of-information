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
@Table(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class Account {
    @Id
    @XmlAttribute(name = "Account")
    private String accountNumber;
    @XmlAttribute(name = "RegulationAccountType")
    private String regulationAccountType;
    @XmlAttribute(name = "CK")
    private String controlKey;
    @XmlAttribute(name = "AccountCBRBIC")
    private int accountCBRBIC;
    @Temporal(TemporalType.DATE)
    @XmlAttribute(name = "DateIn")
    private Date dateIn;
    @XmlAttribute(name = "AccountStatus")
    private String accountStatus;
    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bicDirectoryEntry_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private BICDirectoryEntry bicDirectoryEntry;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    @XmlElement(name = "AccRstrList", namespace="urn:cbr-ru:ed:v2.0")
    private List<AccountRestrictions> accountRestrictions;
}
