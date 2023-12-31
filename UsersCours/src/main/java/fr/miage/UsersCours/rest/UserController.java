package fr.miage.UsersCours.rest;

import fr.miage.UsersCours.repository.ClassDetailsRepository;
import fr.miage.UsersCours.transientobj.ClassDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController("/")
public class UserController {

    @Autowired
    ClassDetailsRepository classDetailsRepository;

    @GetMapping("{id}")
    public ClassDetails getClassDetails(@PathVariable("id") Long id) {
        try {
            return this.classDetailsRepository.getClassDetails(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }

    /*@PostMapping("")
    public ClassDetails post(@RequestBody User user) {
        try {
            return this.userWithClassRepository.save(user);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }*/
}
