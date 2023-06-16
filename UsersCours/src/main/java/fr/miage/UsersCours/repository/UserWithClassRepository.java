package fr.miage.UsersCours.repository;

import fr.miage.UsersCours.transientobj.User;
import fr.miage.UsersCours.transientobj.UserWithClass;

public interface UserWithClassRepository {

    User getUserWithClass(Long idUser) throws Exception;

    User save(User user) throws Exception;
}
