package com.familyapp.liabilities;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LiabilityRepository extends JpaRepository<Liability, Long> {
    
}
