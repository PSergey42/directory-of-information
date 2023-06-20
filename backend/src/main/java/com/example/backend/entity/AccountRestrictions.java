package com.example.backend.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "accountRestrictions",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"account_number", "accRSTR"})
        }
)
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountRestrictions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_number", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Account account;
    @XmlAttribute(name = "AccRstr")
    private String accRSTR;
    @Temporal(TemporalType.DATE)
    @XmlAttribute(name = "AccRstrDate")
    private Date accRSTRDate;

}
