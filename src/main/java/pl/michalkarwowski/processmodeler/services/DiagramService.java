package pl.michalkarwowski.processmodeler.services;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalkarwowski.processmodeler.dto.DiagramDTO;
import pl.michalkarwowski.processmodeler.dto.DiagramDetailsDTO;
import pl.michalkarwowski.processmodeler.models.Diagram;
import pl.michalkarwowski.processmodeler.repositories.DiagramRepository;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class DiagramService {

    private final DiagramRepository repository;
    private final ModelMapper modelMapper;

    private Type DiagramDetailsDTOType = new TypeToken<List<DiagramDetailsDTO>>() {}.getType();

    @Autowired
    public DiagramService(DiagramRepository repository,
                          ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;

        modelMapper.typeMap(Diagram.class, DiagramDTO.class).addMappings(mapper -> mapper.map(Diagram::getXml, DiagramDTO::setDiagramXML));
        // todo: create mapping for image url
        modelMapper.typeMap(Diagram.class, DiagramDetailsDTO.class).addMappings(mapper -> {
//            mapper.<String>map(src -> src.getId(), (diagramDetailsDTO, o) -> diagramDetailsDTO.setImageUrl("localhost:8080/diagrams/img"+ o.toString()));
            mapper.skip(DiagramDetailsDTO::setImageUrl);
        });
    }

    public List<DiagramDetailsDTO> getDiagrams() {
        List<Diagram> diagrams = repository.findAll();
        List<DiagramDetailsDTO> diagramsDetails = modelMapper.map(diagrams, DiagramDetailsDTOType);
        return diagramsDetails;
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
//        InputStream in = this.getClass().getResourceAsStream(String.format("/static/diagrams_png/diagram%d.png", diagramId));
//        byte[] image = IOUtils.toByteArray(in);

//        Optional<Diagram> diagram = repository.findById(diagramId);
//        if (diagram.isPresent()) {
//            Diagram d = diagram.get();
//            d.setImage(image);
//            repository.save(d);
//        }
    }

}
