package pl.michalkarwowski.processmodeler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.michalkarwowski.processmodeler.dto.DiagramDTO;
import pl.michalkarwowski.processmodeler.dto.DiagramDetailsDTO;
import pl.michalkarwowski.processmodeler.services.DiagramService;

import java.util.List;

@RestController
public class DiagramController {

    private final DiagramService diagramService;

    @Autowired
    public DiagramController(DiagramService diagramService) {
        this.diagramService = diagramService;
    }

    @GetMapping("/diagrams")
    public ResponseEntity<List<DiagramDetailsDTO>> getDiagrams() {
        List<DiagramDetailsDTO> diagramsDetails = diagramService.getDiagrams();
        return new ResponseEntity<>(diagramsDetails, HttpStatus.OK);
    }

    @PostMapping("/diagrams")
    public ResponseEntity<?> createDiagram() {
        return ResponseEntity.ok("saved");
    }

    @GetMapping("/diagrams/{id}")
    public ResponseEntity<DiagramDTO> getDiagram(@PathVariable Long id) {
        DiagramDTO diagramDTO = diagramService.getDiagram(id);
        if (diagramDTO != null)
            return new ResponseEntity<>(diagramDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PutMapping("/diagrams/{id}")
    public ResponseEntity<?> updateDiagram(@PathVariable String id) {
        return ResponseEntity.ok("updated");
    }

    @DeleteMapping("/diagrams/{id}")
    public ResponseEntity<?> deleteDiagram(@PathVariable String id) {
        return ResponseEntity.ok("updated");
    }

    @GetMapping("/diagrams/{id}/image")
    public ResponseEntity<?> getDiagramImage(@PathVariable Long id) {
        return ResponseEntity.ok().build();
    }

}
