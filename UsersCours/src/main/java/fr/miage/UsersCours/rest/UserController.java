package fr.miage.UsersCours.rest;

import fr.miage.UsersCours.repository.UserWithClassRepository;
import fr.miage.UsersCours.transientobj.User;
import fr.miage.UsersCours.transientobj.UserWithClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController("/")
public class UserController {

    @Autowired
    UserWithClassRepository userWithClassRepository;

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Long id) {
        try {
            return this.userWithClassRepository.getUserWithClass(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    @PostMapping("")
    public User postUser(@RequestBody User user) {
        try {
            return this.userWithClassRepository.save(user);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }
}
