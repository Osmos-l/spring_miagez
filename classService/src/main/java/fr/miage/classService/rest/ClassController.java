package fr.miage.classService.rest;

import fr.miage.classService.entities.Class;
import fr.miage.classService.services.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/")
public class ClassController {

    @Autowired
    ClassService classService;

    @GetMapping("{id}")
    public Class getClass(@PathVariable("id") Long id) {
        try {
            return this.classService.getClassByID(id);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }

    }


    @PostMapping("")
    public Class postClass(@RequestBody Class toCreate) {
        try {
            return this.classService.createClass(toCreate);
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        }
    }
}
