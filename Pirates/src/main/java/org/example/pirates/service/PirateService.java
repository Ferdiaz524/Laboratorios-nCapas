package org.example.pirates.service;

import org.example.pirates.domain.entity.Pirate;

import java.util.List;
import java.util.UUID;

public interface PirateService {
    void createPirate(Pirate pirate);
    List<Pirate> getAllPirates();
    Pirate getPirateById(UUID id);
    void updatePirate(UUID id, Pirate pirate);
    Pirate deletePirate(UUID id);
}
