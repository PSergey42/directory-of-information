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
        name = "participantRestrictions",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"participantInfo_id", "rstr"})
        }
)
public class ParticipantRestrictions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne()
    @JoinColumn(name = "participantInfo_id", foreignKey = @ForeignKey(ConstraintMode.CONSTRAINT))
    private ParticipantInfo participantInfo;
    private String rstr;
    private Date rstrDate;

}
