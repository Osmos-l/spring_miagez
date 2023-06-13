package fr.miage.UsersCours.repository;

import fr.miage.UsersCours.transientobj.User;

public interface UserWithClassRepository {

    User getUserWithClass(Long idUser);

    User save(User user);
}
