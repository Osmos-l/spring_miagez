package fr.miage.UsersCours.transientobj;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    public long id;

    public String firstname;

    public String lastname;

    public String email;

    public String login;

    public String password;
}