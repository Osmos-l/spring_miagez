package fr.miage.usersservice.rest;

import fr.miage.usersservice.entities.User;
import fr.miage.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") Long id) {
        try {
            return this.userService.getUserById(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }


    @PostMapping("")
    public User postUser(@RequestBody User user) {
        try {
            return this.userService.createUser(user);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }


}
