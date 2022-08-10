package com.familyapp.user;

import java.util.List;

public interface IUserService {

    User findById(long id);

    List<User> findAll();

    boolean delete(long id);

    User create(User user);

    User update(long id, User formData);
}
