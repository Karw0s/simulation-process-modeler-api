package pl.michalkarwowski.processmodeler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.michalkarwowski.processmodeler.models.Diagram;

public interface DiagramRepository extends JpaRepository<Diagram, Long> {

}
