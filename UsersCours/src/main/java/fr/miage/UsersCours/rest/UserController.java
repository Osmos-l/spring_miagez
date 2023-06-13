package fr.miage.UsersCours.rest;

import fr.miage.UsersCours.repository.UserWithClassRepository;
import fr.miage.UsersCours.transientobj.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class UserController {

    @Autowired
    UserWithClassRepository userWithClassRepository;

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userWithClassRepository.getUserWithClass(id);
    }

    @PostMapping("")
    public User postUser(@RequestBody User user) {
        return this.userWithClassRepository.save(user);
    }
}
