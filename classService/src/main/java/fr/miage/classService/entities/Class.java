package fr.miage.classService.entities;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;

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
    public Date date;

    @NonNull
    public String location;

    @NonNull
    public String idParticipants;

    public ArrayList<Long> getIdParticipants() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(this.idParticipants, new TypeReference<ArrayList<Long>>() {});
        } catch (Exception ex) {
            return new ArrayList<Long>();
        }

    }
}
