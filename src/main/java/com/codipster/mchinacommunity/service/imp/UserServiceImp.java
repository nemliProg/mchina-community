package com.codipster.mchinacommunity.service.imp;

import com.codipster.mchinacommunity.mongodocs.Role;
import com.codipster.mchinacommunity.mongodocs.User;
import com.codipster.mchinacommunity.repository.UserRepository;
import com.codipster.mchinacommunity.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

        private final UserRepository userRepository;

        public UserServiceImp(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        @Override
        public User saveUser(User user) {
            return userRepository.save(user);
        }

        @Override
        public User getUser(String username){
            Optional<User> user = userRepository.findByUsername(username);
            return user.orElse(null);
        }

        @Override
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

        @Override
        public User updateUser(User updatedUser) {
            Optional<User> user = userRepository.findByUsername(updatedUser.getUsername());
            User user1 = user.orElse(null);
            if (user1 == null) {
                return null;
            }
            user1.setEmail(updatedUser.getEmail());
            user1.setUsername(updatedUser.getUsername());
            user1.setPassword(updatedUser.getPassword());
            return userRepository.save(user1);
        }

        @Override
        public void deleteUser(String username) {
            Optional<User> user = userRepository.findByUsername(username);
            user.ifPresent(userRepository::delete);
        }


}
