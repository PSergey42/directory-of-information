package com.example.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "emailMessage")
public class EmailMessage {
    @Id
    private int edNo;
    private long edAuthor;
    private long edReceiver;
    private Date edDate;
    private String creationReason;
    private Date creationDateTime;
    private String infoTypeCode;
    private Date businessDay;
    private int directoryVersion;
}
