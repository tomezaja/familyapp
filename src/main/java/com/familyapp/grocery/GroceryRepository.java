package com.familyapp.grocery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository  extends JpaRepository<Grocery, Long>{
    
}
