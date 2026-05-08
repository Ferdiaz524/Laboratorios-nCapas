package org.example.pirates.controller;

import lombok.AllArgsConstructor;
import org.example.pirates.domain.entity.Pirate;
import org.example.pirates.service.impl.PirateServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pirates")
@AllArgsConstructor
public class PirateController {
    private final PirateServiceImpl pirateService;

    @PostMapping
    public ResponseEntity<Pirate> createProduct(@RequestBody Pirate pirate) {
        pirateService.createPirate(pirate);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pirate);
    }
    @GetMapping
    public ResponseEntity<List<Pirate>> getAllPirates(){
        List<Pirate> pirates = pirateService.getAllPirates();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pirates);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pirate> getPirateById( @PathVariable UUID id){

        Pirate pirate = pirateService.getPirateById(id);

        if (pirate == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pirateService.getPirateById(id));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Pirate> updatePirate(@PathVariable UUID id, @RequestBody Pirate pirate){
        pirateService.updatePirate(id, pirate);
        pirate.setId(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(pirate);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Pirate> deletePirate(@PathVariable UUID id){
        Pirate deleted = pirateService.deletePirate(id);
        return ResponseEntity.ok(deleted);
    }
}