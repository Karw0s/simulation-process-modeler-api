package pl.michalkarwowski.processmodeler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.michalkarwowski.processmodeler.dto.DiagramCreateDTO;
import pl.michalkarwowski.processmodeler.dto.DiagramDTO;
import pl.michalkarwowski.processmodeler.dto.DiagramDetailsDTO;
import pl.michalkarwowski.processmodeler.dto.DiagramUpdateDTO;
import pl.michalkarwowski.processmodeler.services.DiagramService;

import java.io.IOException;
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

    @PostMapping(value = "/diagrams", consumes = "multipart/form-data")
    public ResponseEntity<DiagramDTO> createDiagram(@ModelAttribute DiagramCreateDTO diagramCreateDTO) throws IOException {
        return new ResponseEntity<>(diagramService.createDiagram(diagramCreateDTO), HttpStatus.CREATED);
    }

    @GetMapping("/diagrams/{id}")
    public ResponseEntity<DiagramDTO> getDiagram(@PathVariable Long id) {
        DiagramDTO diagramDTO = diagramService.getDiagram(id);
        if (diagramDTO != null)
            return new ResponseEntity<>(diagramDTO, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/diagrams/{id}/image", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getDiagramImage(@PathVariable Long id) {
        return diagramService.getDiagramImage(id);
    }

    @PutMapping(value = "/diagrams/{id}", consumes = "multipart/form-data")
    public ResponseEntity<DiagramDTO> updateDiagram(@PathVariable Long id, @ModelAttribute DiagramUpdateDTO diagramUpdateDTO) throws IOException {
        DiagramDTO diagramDTO = diagramService.updateDiagram(id, diagramUpdateDTO);
        return ResponseEntity.ok(diagramDTO);
    }

    @DeleteMapping("/diagrams/{id}")
    public ResponseEntity<?> deleteDiagram(@PathVariable Long id) {
        diagramService.deleteDiagram(id);
        return ResponseEntity.ok().build();
    }

}
