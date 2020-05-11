package pl.michalkarwowski.processmodeler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.michalkarwowski.processmodeler.dto.SimProperties.SimPropertiesCreateDTO;
import pl.michalkarwowski.processmodeler.dto.SimProperties.SimulationPropertiesListItemDTO;
import pl.michalkarwowski.processmodeler.models.SimulationProperties;
import pl.michalkarwowski.processmodeler.services.DiagramService;

import java.util.List;

@RestController
public class SimulationPropertiesController {

    private final DiagramService diagramService;

    @Autowired
    public SimulationPropertiesController(DiagramService diagramService) {
        this.diagramService = diagramService;
    }

    @GetMapping("/simProperties")
    public ResponseEntity<List<SimulationPropertiesListItemDTO>> getDiagramSimPropertiesList(@RequestParam Long diagramId) {
        return ResponseEntity.ok(diagramService.getDiagramSimulationProperties(diagramId));
    }

    @PostMapping("/simProperties")
    public ResponseEntity<SimulationProperties> getDiagramSimPropertiesList(@RequestParam Long diagramId, @RequestBody SimPropertiesCreateDTO simPropertiesCreateDTO) {
        return ResponseEntity.ok(diagramService.addSimulationProperties(diagramId, simPropertiesCreateDTO));
    }

    @GetMapping("/simProperties/{id}")
    public ResponseEntity<?> getSimulationProperties(@PathVariable Long id) {
        return ResponseEntity.ok(diagramService.getSimProperties(id));
    }

    @PutMapping("/simProperties/{id}")
    public ResponseEntity<SimulationProperties> updateDiagramSimProperties(@PathVariable Long id, @RequestBody SimPropertiesCreateDTO simPropertiesCreateDTO) {
        return ResponseEntity.ok(diagramService.updateSimProperties(id, simPropertiesCreateDTO));
    }

    @DeleteMapping("/simProperties/{id}")
    public ResponseEntity<?> deleteSimulationProperties(@PathVariable Long id) {
        diagramService.deleteSimProperties(id);
        return ResponseEntity.ok().build();
    }
}
