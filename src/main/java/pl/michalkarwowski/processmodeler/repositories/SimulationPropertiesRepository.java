package pl.michalkarwowski.processmodeler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalkarwowski.processmodeler.models.SimulationProperties;

import java.util.List;

public interface SimulationPropertiesRepository extends JpaRepository<SimulationProperties, Long> {
    List<SimulationProperties> findAllByDiagram_Id(Long id);
}
