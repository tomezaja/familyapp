package com.familyapp.message;

import java.util.List;

public interface IMessageService {

    Message findById(long id);

    List<Message> findAll();

    boolean delete(long id);

    Message create(Message message);

    Message update(long id, Message formData);
}
