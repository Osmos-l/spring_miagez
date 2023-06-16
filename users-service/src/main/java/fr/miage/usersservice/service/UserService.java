package fr.miage.usersservice.service;

import fr.miage.usersservice.entities.User;
import fr.miage.usersservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) throws Exception {

        if (userRepository.findOneByEmail(user.getEmail()) != null) {
            throw new Exception("Email already used");
        }

        if (userRepository.findOneByLogin(user.getLogin()) != null) {
            throw new Exception("Login already used");
        }

        return userRepository.save(user);
    }

    public User getUserById(Long id) throws Exception {
        try {
            return userRepository.findById(id).get();
        } catch (Exception ex) {
            throw new Exception("User not found");
        }
    }
}
