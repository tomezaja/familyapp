package com.familyapp.lunch;

import java.util.List;

public interface ILunchService {
    
    Lunch findById(long id);

    List<Lunch> findAll();

    boolean delete(long id);

    Lunch create(Lunch lunch );
   
    Lunch update(long id, Lunch formData);

}
