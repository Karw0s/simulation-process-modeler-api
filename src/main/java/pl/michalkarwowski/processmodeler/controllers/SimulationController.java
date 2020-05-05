package pl.michalkarwowski.processmodeler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.michalkarwowski.processmodeler.services.SimulationService;

@RestController
public class SimulationController {

    private final SimulationService simulationService;

    @Autowired
    public SimulationController(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @GetMapping("/simulation/{id}")
    public ResponseEntity<?> getSimulationProperties(@PathVariable Long id) {
        simulationService.getSimProperties(id);
        return ResponseEntity.ok().build();
    }
}
