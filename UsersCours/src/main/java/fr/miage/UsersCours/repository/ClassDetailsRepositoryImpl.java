package fr.miage.UsersCours.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.miage.UsersCours.transientobj.Class;
import fr.miage.UsersCours.transientobj.ClassDetails;
import fr.miage.UsersCours.transientobj.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;

public class ClassDetailsRepositoryImpl implements ClassDetailsRepository {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected RestTemplate restTemplateUser;

    @Autowired
    protected RestTemplate restTemplateClass;

    protected String userServiceURL;

    protected String classServiceURL;

    public ClassDetailsRepositoryImpl(String userServiceURL, String classServiceURL) {
        this.userServiceURL = userServiceURL;
        this.classServiceURL = classServiceURL;
    }



    @Override
    public ClassDetails getClassDetails(Long idClass) throws Exception {
        logger.info("On a la demande");

        Class simpleClass = null;
        try  {
            simpleClass = restTemplateClass.getForObject(this.classServiceURL+"/{id}", Class.class, idClass);
        }  catch (RestClientResponseException ex) {
            logger.info("on a une erreur : {}", ex);
            throw new Exception(ex.getMessage());
        }

        ClassDetails classDetails = new ClassDetails();
        classDetails.setId(simpleClass.getId());
        classDetails.setLocation(simpleClass.getLocation());
        classDetails.setDuration(simpleClass.getDuration());
        classDetails.setName(simpleClass.getName());

        classDetails.setIdTeacher(simpleClass.getIdTeacher());
        try {
            User teacher = restTemplateUser.getForObject(this.userServiceURL+"/{id}", User.class, classDetails.getIdTeacher());
            classDetails.setTeacher(teacher);
        } catch (RestClientResponseException ex) {
            logger.info("on a une erreur : {}", ex);
        }

        classDetails.setIdParticipants(simpleClass.getIdParticipants());

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<Long> idParticipantsList = objectMapper.readValue(simpleClass.getIdParticipants(), new TypeReference<ArrayList<Long>>() {});

            idParticipantsList.forEach((Long idParticipants) -> {
                try {
                    User participant = restTemplateUser.getForObject(this.userServiceURL+"/{id}", User.class, idParticipants);
                    classDetails.getParticipants().add(participant);
                } catch (RestClientResponseException ex) {
                    logger.info("on a une erreur : {}", ex);
                }
            });
        } catch (IOException ex) {
            logger.info("on a une erreur : {}", ex);
        }

        return classDetails;
    }
}
