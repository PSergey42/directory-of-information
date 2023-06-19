package com.example.backend.repository;

import com.example.backend.entity.ParticipantRestrictions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRestrictionsRepository extends JpaRepository<ParticipantRestrictions, Long> {
}
