package com.example.backend.entity;

import jakarta.persistence.*;
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
public class Account {
    @Id
    private String accountNumber;
    private String regulationAccountType;
    private String controlKey;
    private int accountCBRBIC;
    private Date dateIn;
    private Date dateOut;
    private String accountStatus;
    @ManyToOne
    @JoinColumn(name = "bicDirectoryEntry_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private BICDirectoryEntry bicDirectoryEntry;
    @OneToMany(mappedBy = "participantInfo", cascade = CascadeType.ALL)
    private List<AccountRestrictions> accountRestrictions;
}
