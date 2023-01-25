package ru.drujishe.service;

import ru.drujishe.model.User;

import java.util.List;

public interface UserService {
    void add(User user);

    void update(int id, User updatedUser);

    void delete(int id);

    List<User> getAll();

    User getUserById(int id);
}
