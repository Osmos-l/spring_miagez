package fr.miage.usersservice.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue
    public Long id;

    @NonNull
    public String firstname;

    @NonNull
    public String lastname;

    @NonNull
    public String email;

    @NonNull
    public String login;

    @NonNull
    public String password;

    @NonNull
    public Boolean isTeacher = false;

    @NonNull
    public Boolean isSecretary = false;

    @NonNull
    public Boolean isPresident = false;
}
