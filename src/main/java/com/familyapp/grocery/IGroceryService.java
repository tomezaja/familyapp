package com.familyapp.grocery;

import java.util.List;

public interface IGroceryService {

    Grocery findById(long id);

    List<Grocery> findAll();

    boolean delete(long id);

    Grocery create(Grocery grocery);

    Grocery update(long id, Grocery formData);
}
