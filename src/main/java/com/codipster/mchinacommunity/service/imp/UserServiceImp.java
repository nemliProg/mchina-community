package com.codipster.mchinacommunity.service.imp;

import com.codipster.mchinacommunity.enums.Roles;
import com.codipster.mchinacommunity.enums.Status;
import com.codipster.mchinacommunity.mongodocs.Role;
import com.codipster.mchinacommunity.mongodocs.User;
import com.codipster.mchinacommunity.repository.UserRepository;
import com.codipster.mchinacommunity.service.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        user.setStatus(Status.ONLINE);
        return userRepository.save(user);
    }

    @Override
    public void disconnect(User user) {
        userRepository.findById(user.getUsername())
                .ifPresent(storedUser -> {
                    storedUser.setStatus(Status.OFFLINE);
                    userRepository.save(storedUser);
                });
    }

    @Override
    public List<User> getConnectedUsers() {
        return userRepository.findAllByStatus(Status.ONLINE);
    }

    @Override
    public User getUser(String username){
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User updatedUser) {
        return userRepository.findById(updatedUser.getUsername())
                .map(user -> {
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    @Override
    public User changeRole(User updatedUser, Roles role) {
        return userRepository.findById(updatedUser.getUsername())
                .map(user -> {
                    user.setRole(role);
                    return userRepository.save(user);
                })
                .orElse(null);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.findByUsername(username)
                .ifPresent(userRepository::delete);
    }


}
