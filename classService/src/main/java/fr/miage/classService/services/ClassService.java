package fr.miage.classService.services;

import fr.miage.classService.entities.User;
import fr.miage.classService.repositories.ClassRepository;
import fr.miage.classService.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.miage.classService.entities.Class;

import java.time.Period;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class ClassService {

    @Autowired
    ClassRepository classRepository;

    @Autowired
    UserRepository userRepository;

    public Class createClass(Class toCreate) throws Exception {
        User teacher = userRepository.getUserById(toCreate.getIdTeacher());
        if (teacher == null) {
            throw new Exception("Teacher not found");
        }
        if (!teacher.getIsTeacher()) {
            throw new Exception("User must be a valid teacher");
        }

        for (Long participantId : toCreate.getIdParticipants()) {
            if (userRepository.getUserById(participantId) == null) {
                throw new Exception("User not found (" + participantId + ")");
            }
        }

        Date today = new Date();

        long differenceMillis = toCreate.getDate().getTime() - today.getTime();
        long differenceDays = TimeUnit.MILLISECONDS.toDays(differenceMillis);

        if (differenceDays < 7) {
            throw new Exception("Date is too close (" + differenceDays +")");
        }

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
