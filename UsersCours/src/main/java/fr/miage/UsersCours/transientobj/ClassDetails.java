package fr.miage.UsersCours.transientobj;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClassDetails extends Class {

    public User teacher;

    public ArrayList<User> participants = new ArrayList<>();
}
