package fr.miage.classService.repositories;

import fr.miage.classService.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class UserRepositoryImpl implements UserRepository {

    @Autowired
    protected RestTemplate userRestTemplate;

    protected String userServiceURL;

    public UserRepositoryImpl(String userServiceURL) {
        this.userServiceURL = userServiceURL;
    }

    @Override
    public User getUserById(Long idUser) {
        try  {
            return userRestTemplate.getForObject(this.userServiceURL+"/{id}", User.class, idUser);
        }  catch (RestClientResponseException ex) {
            return null;
        }
    }
}
