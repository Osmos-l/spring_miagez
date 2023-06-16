package fr.miage.UsersCours.repository;

import fr.miage.UsersCours.transientobj.User;
import fr.miage.UsersCours.transientobj.UserWithClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

public class UserWithClassRepositoryImpl implements UserWithClassRepository {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected RestTemplate restTemplateUser;

    protected String userServiceURL;

    public UserWithClassRepositoryImpl(String userServiceURL) {
        this.userServiceURL = userServiceURL;
    }

    @Override
    public User getUserWithClass(Long idUser) throws Exception {
        logger.info("On a la demande");

        User user = null;
        try {
            user = restTemplateUser.getForObject(this.userServiceURL+"/{id}", User.class, idUser);
        } catch (RestClientResponseException ex) {
            logger.info("on a une erreur : {}", ex);
            throw new Exception(ex.getMessage());
        }
        logger.info("On a la réponse : {}", user);

        UserWithClass userWithClass = new UserWithClass();
        userWithClass.setId(user.getId());
        userWithClass.setFirstname(user.getFirstname());
        userWithClass.setLastname(user.getLastname());
        userWithClass.setEmail(user.getEmail());
        userWithClass.setLogin(user.getLogin());
        userWithClass.setPassword(user.getPassword());
        userWithClass.setIsPresident(user.getIsPresident());
        userWithClass.setIsSecretary(user.getIsSecretary());
        userWithClass.setIsTeacher(user.getIsTeacher());

        return userWithClass;
    }

    @Override
    public User save(User user) throws Exception {
        logger.info("On a la demande");

        try {
            user = restTemplateUser.postForObject(this.userServiceURL+"/", user, User.class);
        } catch (RestClientResponseException ex) {
            logger.info("on a une erreur : {}", ex);
            throw new Exception(ex.getMessage());
        }

        logger.info("On a la réponse : {}", user);
        return user;
    }
}
