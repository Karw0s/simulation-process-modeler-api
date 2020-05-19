package pl.michalkarwowski.processmodeler.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SimulationProperties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String time;
    private String unit;
    private String rate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_diagram")
    @JsonIgnore
    private Diagram diagram;

    @Override
    public String toString() {
        return "SimulationProperties{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                ", unit='" + unit + '\'' +
                ", rate='" + rate + '\'' +
                '}';
    }
}
