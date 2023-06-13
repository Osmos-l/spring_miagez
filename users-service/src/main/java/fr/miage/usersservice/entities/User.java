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
    public long id;

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
}
