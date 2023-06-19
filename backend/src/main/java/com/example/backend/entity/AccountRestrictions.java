package com.example.backend.entity;

import jakarta.persistence.*;
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
public class AccountRestrictions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne()
    @JoinColumn(name = "account_number", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private Account account;
    private String accRSTR;
    private int successorBIC;
    private Date accRSTRDate;

}
