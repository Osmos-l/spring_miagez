package fr.miage.classService.repositories;

import fr.miage.classService.entities.User;

public interface UserRepository {

    User getUserById(Long idUser);
}
