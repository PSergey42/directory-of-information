package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bicDirectoryEntry")
public class BICDirectoryEntry {
    @Id
    private int BIC;
    private String changeType;
    @OneToOne
    private ParticipantInfo participantInfo;
    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private List<SWBIC> swBICs;
    @OneToMany(mappedBy = "bicDirectoryEntry", cascade = CascadeType.ALL)
    private List<Account> accounts;
}
