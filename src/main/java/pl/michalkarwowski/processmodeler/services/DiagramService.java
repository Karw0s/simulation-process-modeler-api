package pl.michalkarwowski.processmodeler.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalkarwowski.processmodeler.dto.DiagramCreateDTO;
import pl.michalkarwowski.processmodeler.dto.DiagramDTO;
import pl.michalkarwowski.processmodeler.dto.DiagramDetailsDTO;
import pl.michalkarwowski.processmodeler.dto.DiagramUpdateDTO;
import pl.michalkarwowski.processmodeler.dto.SimProperties.SimPropertiesCreateDTO;
import pl.michalkarwowski.processmodeler.dto.SimProperties.SimulationPropertiesDTO;
import pl.michalkarwowski.processmodeler.dto.SimProperties.SimulationPropertiesListItemDTO;
import pl.michalkarwowski.processmodeler.models.Diagram;
import pl.michalkarwowski.processmodeler.models.SimulationProperties;
import pl.michalkarwowski.processmodeler.repositories.DiagramRepository;
import pl.michalkarwowski.processmodeler.repositories.SimulationPropertiesRepository;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class DiagramService {

    private final DiagramRepository repository;
    private final SimulationPropertiesRepository simPropRepository;
    private final ModelMapper modelMapper;

    private final Type DiagramDetailsDTOType = new TypeToken<List<DiagramDetailsDTO>>() {}.getType();
    private final Type SimPropertiesListDTOType = new TypeToken<List<SimulationPropertiesListItemDTO>>() {}.getType();

    @Autowired
    public DiagramService(DiagramRepository repository,
                          SimulationPropertiesRepository simPropRepository,
                          ModelMapper modelMapper) {
        this.repository = repository;
        this.simPropRepository = simPropRepository;
        this.modelMapper = modelMapper;

        modelMapper.typeMap(Diagram.class, DiagramDTO.class).addMappings(mapper -> mapper.map(Diagram::getXml, DiagramDTO::setDiagramXML));
        // todo: create mapping for image url
        modelMapper.typeMap(Diagram.class, DiagramDetailsDTO.class).addMappings(mapper -> {
//            mapper.<String>map(src -> src.getId(), (diagramDetailsDTO, o) -> diagramDetailsDTO.setImageUrl("localhost:8080/diagrams/img"+ o.toString()));
            mapper.skip(DiagramDetailsDTO::setImageUrl);
        });
        modelMapper.typeMap(DiagramCreateDTO.class, Diagram.class).addMappings(mapper -> mapper.skip(Diagram::setImage));
    }

    public List<DiagramDetailsDTO> getDiagrams() {
        List<Diagram> diagrams = repository.findAll();
        return modelMapper.map(diagrams, DiagramDetailsDTOType);
    }

    public DiagramDTO createDiagram(DiagramCreateDTO diagramCreateDTO) throws IOException {
        Diagram diagram = modelMapper.map(diagramCreateDTO, Diagram.class);
        diagram.setImage(diagramCreateDTO.getImage().getBytes());
        Diagram save = repository.save(diagram);
        return modelMapper.map(save, DiagramDTO.class);
    }

    public DiagramDTO getDiagram(Long diagramId) {
        Optional<Diagram> diagram = repository.findById(diagramId);
        DiagramDTO diagramDTO = null;
        if (diagram.isPresent()) {
            diagramDTO = modelMapper.map(diagram.get(), DiagramDTO.class);
        }
        return diagramDTO;
    }

    public byte[] getDiagramImage(Long diagramId) {
        Optional<Diagram> diagram = repository.findById(diagramId);
        return diagram.map(Diagram::getImage).orElse(null);
    }

    public DiagramDTO updateDiagram(Long diagramId, DiagramUpdateDTO diagramUpdateDTO) throws IOException {
        Optional<Diagram> diagramOptional = repository.findById(diagramId);
        if (diagramOptional.isPresent()) {
            Diagram diagram = diagramOptional.get();
            diagram.setXml(diagramUpdateDTO.getXml());
            diagram.setName(diagramUpdateDTO.getName());
            diagram.setImage(diagramUpdateDTO.getImage().getBytes());
            Diagram save = repository.save(diagram);
            return modelMapper.map(save, DiagramDTO.class);
        }
        return null;
    }

    public void deleteDiagram(Long diagramId) {
        repository.deleteById(diagramId);
    }

    public List<SimulationPropertiesListItemDTO> getDiagramSimulationProperties(Long diagramId) {
        List<SimulationProperties> simProp = simPropRepository.findAllByDiagram_Id(diagramId);
        return modelMapper.map(simProp, SimPropertiesListDTOType);
    }

    public SimulationProperties addSimulationProperties(Long diagramId, SimPropertiesCreateDTO simPropertiesCreateDTO) {
        Optional<Diagram> diagram = repository.findById(diagramId);
        if (diagram.isPresent()) {
            Diagram dbDiagram = diagram.get();
            SimulationProperties simulationProperties = modelMapper.map(simPropertiesCreateDTO, SimulationProperties.class);
            simulationProperties.setDiagram(dbDiagram);
            SimulationProperties save = simPropRepository.save(simulationProperties);
//            dbDiagram.getSimulationsProperties().add(simulationProperties);
//            repository.save(dbDiagram);
            return save;
        } else {
            return null;
        }
    }

    public SimulationProperties updateSimProperties(Long id, SimPropertiesCreateDTO simPropertiesCreateDTO) {
        Optional<SimulationProperties> simulationProperties = simPropRepository.findById(id);
        if (simulationProperties.isPresent()) {
            SimulationProperties properties = simulationProperties.get();
            properties.setName(simPropertiesCreateDTO.getName());
            properties.setRate(simPropertiesCreateDTO.getRate());
            properties.setTime(simPropertiesCreateDTO.getTime());
            properties.setUnit(simPropertiesCreateDTO.getUnit());
            return simPropRepository.save(properties);
        }
        return null;
    }

    public void deleteSimProperties(Long id) {
        SimulationProperties simulationProperties = simPropRepository.findById(id).orElse(null);
        if (simulationProperties != null) {
            Optional<Diagram> diagramOptional = repository.findById(simulationProperties.getDiagram().getId());
            if (diagramOptional.isPresent()) {
                diagramOptional.get().getSimulationsProperties().remove(simulationProperties);
                simPropRepository.delete(simulationProperties);
            }
        }

    }

    public SimulationPropertiesDTO getSimProperties(Long id) {
        Optional<SimulationProperties> byId = simPropRepository.findById(id);
        SimulationPropertiesDTO dto = null;
        if (byId.isPresent()) {
            dto = modelMapper.map(byId.get(), SimulationPropertiesDTO.class);
        }
        return dto;
    }
}
