package fr.miage.usersservice.rest;

import fr.miage.usersservice.entities.User;
import fr.miage.usersservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("")
    public User postUser(@RequestBody User user) {
        return this.userRepository.save(user);
    }
}
