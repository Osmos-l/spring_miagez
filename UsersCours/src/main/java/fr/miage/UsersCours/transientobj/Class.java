package fr.miage.UsersCours.transientobj;

import lombok.*;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Class {

    public Long id;

    public String name;

    public Long idTeacher;

    public String duration;

    public String location;

    public String idParticipants;
}
