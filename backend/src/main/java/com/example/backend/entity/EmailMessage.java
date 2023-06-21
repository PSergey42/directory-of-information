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
@Table(name = "email_message")
@XmlRootElement(name = "ED807", namespace="urn:cbr-ru:ed:v2.0")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmailMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @XmlTransient
    private long id;
    @XmlAttribute(name = "EDNo")
    private int edNo;
    @XmlAttribute(name = "EDAuthor")
    private long edAuthor;
    @Temporal(TemporalType.DATE)
    @XmlAttribute(name = "EDDate")
    private Date edDate;
    @XmlAttribute(name = "CreationReason")
    private String creationReason;
    @XmlAttribute(name = "CreationDateTime")
    private Date creationDateTime;
    @XmlAttribute(name = "InfoTypeCode")
    private String infoTypeCode;
    @Temporal(TemporalType.DATE)
    @XmlAttribute(name = "BusinessDay")
    private Date businessDay;
    @XmlAttribute(name = "DirectoryVersion")
    private int directoryVersion;
    @OneToMany(mappedBy = "emailMessage", cascade = CascadeType.ALL)
    @XmlElement(name = "BICDirectoryEntry", namespace="urn:cbr-ru:ed:v2.0")
    private List<BICDirectoryEntry> bicDirectoryEntryList;

}
