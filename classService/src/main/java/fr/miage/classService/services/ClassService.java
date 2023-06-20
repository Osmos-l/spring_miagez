package fr.miage.classService.services;

import fr.miage.classService.repositories.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.miage.classService.entities.Class;

@Service
public class ClassService {

    @Autowired
    ClassRepository classRepository;

    public Class createClass(Class toCreate) throws Exception {
        return classRepository.save(toCreate);
    }

    public Class getClassByID(Long classID) throws Exception {
        try {
            return classRepository.findById(classID).get();
        } catch (Exception ex) {
            throw new Exception("Class not found");
        }
    }
}
