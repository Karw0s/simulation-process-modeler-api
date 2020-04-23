package pl.michalkarwowski.processmodeler.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalkarwowski.processmodeler.controllers.DiagramMock;
import pl.michalkarwowski.processmodeler.dto.DiagramDTO;
import pl.michalkarwowski.processmodeler.dto.DiagramDetailsDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiagramService {

    private final ModelMapper modelMapper;

    @Autowired
    public DiagramService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public List<DiagramDetailsDTO> getDiagrams() {
        List<DiagramDetailsDTO> diagramsDetails = new ArrayList<>();
        diagramsDetails.add(DiagramDetailsDTO.builder().id(1L).name("Diagram1").imageUrl("diagram1.png").build());
        diagramsDetails.add(DiagramDetailsDTO.builder().id(2L).name("Diagram2").imageUrl("diagram2.png").build());

        return diagramsDetails;
    }

    public DiagramDTO getDiagram(Long diagramId) {
        DiagramDTO diagramDTO = null;
        if (diagramId == 1) {
            diagramDTO = new DiagramDTO();
            diagramDTO.setId(diagramId);
            diagramDTO.setDiagramXML(DiagramMock.diagram1XML);
        } else if (diagramId == 2) {
            diagramDTO = new DiagramDTO();
            diagramDTO.setId(diagramId);
            diagramDTO.setDiagramXML(DiagramMock.diagram2XML);
        }
        return diagramDTO;
    }

}
