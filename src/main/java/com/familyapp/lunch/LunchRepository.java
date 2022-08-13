package com.familyapp.lunch;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LunchRepository extends JpaRepository<Lunch, Long> {

}