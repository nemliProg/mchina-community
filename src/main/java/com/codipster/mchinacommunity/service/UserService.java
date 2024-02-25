package com.codipster.mchinacommunity.service;

import com.codipster.mchinacommunity.mongodocs.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    User getUser(String username);
    List<User> getAllUsers();
    User updateUser(User user);
    void deleteUser(String username);
}
