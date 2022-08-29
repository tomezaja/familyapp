package com.familyapp.reservation;

import java.util.List;

public interface IReservationService {
    
    Reservation findById(long id);

    List<Reservation> findAll();

    boolean delete(long id);

    Reservation create(Reservation reservation);

    Reservation update(Long id, Reservation formData);
}
