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
        name = "participantRestrictions",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"participantInfo_id", "rstr"})
        }
)
@XmlAccessorType(XmlAccessType.FIELD)
public class ParticipantRestrictions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participantInfo_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private ParticipantInfo participantInfo;
    @XmlAttribute(name = "Rstr")
    private String rstr;
    @Temporal(TemporalType.DATE)
    @XmlAttribute(name = "RstrDate")
    private Date rstrDate;

}
