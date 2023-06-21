package com.example.backend.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlTransient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SWBIC")
@XmlAccessorType(XmlAccessType.FIELD)
public class SWBIC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private long id;
    @XmlAttribute(name = "SWBIC")
    private String swBIC;
    @XmlAttribute(name = "DefaultSWBIC")
    private boolean defaultSWBIC;
    @XmlTransient
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bicDirectoryEntry_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private BICDirectoryEntry bicDirectoryEntry;
}
