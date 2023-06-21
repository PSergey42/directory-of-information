package com.example.backend.repository;

import com.example.backend.entity.SWBIC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SWBICRepository extends JpaRepository<SWBIC, Long> {
}
