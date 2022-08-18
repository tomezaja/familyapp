package com.familyapp.obligation;

import java.util.List;

public interface IObligationService {

    Obligation findById(long id);

    List<Obligation> findAll();

    boolean delete(long id);

    Obligation create(Obligation obligation);

    Obligation update(long id, Obligation formData);
}
