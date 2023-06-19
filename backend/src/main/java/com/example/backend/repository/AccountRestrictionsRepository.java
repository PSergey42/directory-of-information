package com.example.backend.repository;

import com.example.backend.entity.AccountRestrictions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRestrictionsRepository extends JpaRepository<AccountRestrictions, Long> {
}
