package pl.michalkarwowski.processmodeler.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.michalkarwowski.processmodeler.dto.DiagramDTO;
import pl.michalkarwowski.processmodeler.dto.DiagramDetailsDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DiagramController {

    @GetMapping("/diagrams")
    public ResponseEntity<List<DiagramDetailsDTO>> getDiagrams() {
        List<DiagramDetailsDTO> diagramsDetails = new ArrayList<>();
        diagramsDetails.add(DiagramDetailsDTO.builder().id(1L).name("Diagram1").imageUrl("diagram1.png").build());
        diagramsDetails.add(DiagramDetailsDTO.builder().id(2L).name("Diagram2").imageUrl("diagram2.png").build());

        return new ResponseEntity<>(diagramsDetails, HttpStatus.OK);
    }

    @GetMapping("/diagrams/{id}")
    public ResponseEntity<DiagramDTO> getDiagrams(@PathVariable Long id) {
        DiagramDTO diagramDTO = null;
        if (id == 1) {
            diagramDTO = new DiagramDTO();
            diagramDTO.setId(id);
            diagramDTO.setXML(DiagramMock.diagram1XML);
        }
        else if (id == 2) {
            diagramDTO = new DiagramDTO();
            diagramDTO.setId(id);
            diagramDTO.setXML(DiagramMock.diagram2XML);
        }

        if (diagramDTO != null)
            return new ResponseEntity<>(diagramDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
