package com.familyapp.bill;

import java.util.List;

public interface IBillService {

    Bill findById(long id);

    List<Bill> findAll();

    boolean delete(long id);

    Bill create(Bill bill);

    Bill update(long id, Bill formData);
}
