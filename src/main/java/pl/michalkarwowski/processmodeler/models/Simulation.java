package pl.michalkarwowski.processmodeler.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Simulation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String time;
    @ManyToOne
    private SimulationUnit unit;
    private String rate;
}
