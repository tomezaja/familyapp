package com.familyapp.obligation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ObligationRepository extends JpaRepository<Obligation, Long> {
    
}
