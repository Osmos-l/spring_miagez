package fr.miage.UsersCours.repository;

import fr.miage.UsersCours.transientobj.ClassDetails;

public interface ClassDetailsRepository {

    ClassDetails getClassDetails(Long idClass) throws Exception;

}
