package pl.michalkarwowski.processmodeler.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Diagram {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String xml;
    private String image;
}
