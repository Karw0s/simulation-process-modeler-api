package pl.michalkarwowski.processmodeler.models;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity
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
}
