package com.codipster.mchinacommunity.service;

import com.codipster.mchinacommunity.enums.Roles;
import com.codipster.mchinacommunity.mongodocs.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    void disconnect(User user);
    List<User> getConnectedUsers();
    User getUser(String username);
    List<User> getAllUsers();
    User updateUser(User user);
    User changeRole(User user, Roles role);
    void deleteUser(String username);
}
