package pl.michalkarwowski.processmodeler.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalkarwowski.processmodeler.repositories.DiagramRepository;
import pl.michalkarwowski.processmodeler.repositories.SimulationPropertiesRepository;

@Service
public class SimulationService {

    private final SimulationPropertiesRepository simRepository;
    private final DiagramRepository diagramRepository;
    private final ModelMapper mapper;

    @Autowired
    public SimulationService(SimulationPropertiesRepository simRepository,
                             DiagramRepository diagramRepository,
                             ModelMapper mapper) {
        this.simRepository = simRepository;
        this.diagramRepository = diagramRepository;
        this.mapper = mapper;
    }

    public void getSimProperties(Long id) {

    }
}
