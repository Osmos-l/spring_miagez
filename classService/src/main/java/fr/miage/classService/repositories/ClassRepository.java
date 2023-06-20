package fr.miage.classService.repositories;

import fr.miage.classService.entities.Class;
import org.springframework.data.repository.CrudRepository;

public interface ClassRepository extends CrudRepository<Class, Long> {
}
