package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailMessage {
    private int edNo;
    private int edAuthor;
    private Date edDate;
    private String formMessage;
    private String creationReason;
    private Date creationDateTime;
    private String infoTypeCode;
    private Date businessDay;
    private List<BICDirectoryEntry> records;
}
