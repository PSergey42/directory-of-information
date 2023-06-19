package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SWBIC")
public class SWBIC {
    @Id
    private String swBIC;
    private boolean defaultSWBIC;
    @ManyToOne
    @JoinColumn(name = "bicDirectoryEntry_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private BICDirectoryEntry bicDirectoryEntry;
}
