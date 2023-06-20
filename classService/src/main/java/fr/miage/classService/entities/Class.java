package fr.miage.classService.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Class {

    @Id
    @GeneratedValue
    public Long id;

    @NonNull
    public String name;

    @NonNull
    public Long idTeacher;

    @NonNull
    public String duration;

    @NonNull
    public String location;

    @NonNull
    public String idParticipants;
}
