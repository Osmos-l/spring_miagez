package fr.miage.UsersCours.transientobj;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User {

    public long id;

    public String firstname;

    public String lastname;

    public String email;

    // Données pas utile dans un sens métier
    // public String login;

    // public String password;

    public Boolean isTeacher = false;

    public Boolean isSecretary = false;

    public Boolean isPresident = false;
}