package pl.michalkarwowski.processmodeler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalkarwowski.processmodeler.models.Simulation;

public interface SimulationRepository extends JpaRepository<Simulation, Long> {
}
