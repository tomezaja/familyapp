package com.familyapp.liabilities;

import java.util.List;

public interface ILiabilityService {

    Liability findById(long id);

    List<Liability> findAll();

    boolean delete(long id);

    Liability create(Liability liability);

    Liability update(long id, Liability formData);
}
