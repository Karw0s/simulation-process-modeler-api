package pl.michalkarwowski.processmodeler.models;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "diagrams")
public class Diagram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String xml;
    @Lob
    @Type(type = "org.hibernate.type.ImageType")
    private byte[] image;
    @OneToMany(
            mappedBy = "diagram",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<SimulationProperties> simulationsProperties = new ArrayList<>();
}
