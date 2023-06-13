package fr.miage.UsersCours.repository;

import fr.miage.UsersCours.transientobj.User;
import fr.miage.UsersCours.transientobj.UserWithClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class UserWithClassRepositoryImpl implements UserWithClassRepository {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected RestTemplate restTemplateUser;

    protected String userServiceURL;

    public UserWithClassRepositoryImpl(String userServiceURL) {
        this.userServiceURL = userServiceURL;
    }

    @Override
    public User getUserWithClass(Long idUser) {
        logger.info("On a la demande");

        User user = restTemplateUser.getForObject(this.userServiceURL+"/{id}", User.class, idUser);
        logger.info("On a la réponse : {}", user);

        UserWithClass userWithClass = new UserWithClass();
        userWithClass.setId(user.getId());
        userWithClass.setFirstname(user.getFirstname());
        userWithClass.setLastname(user.getLastname());
        userWithClass.setEmail(user.getEmail());
        userWithClass.setLogin(user.getLogin());
        userWithClass.setPassword(user.getPassword());
        return user;
    }

    @Override
    public User save(User user) {
        logger.info("On a la demande");
        user = restTemplateUser.postForObject(this.userServiceURL+"/", user, User.class);

        logger.info("On a la réponse : {}", user);
        return user;
    }
}
