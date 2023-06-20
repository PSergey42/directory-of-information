package com.example.backend.entity.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class EmailMessagePojo {
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
