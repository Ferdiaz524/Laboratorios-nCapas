package org.example.pirates.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.pirates.domain.entity.Pirate;
import org.example.pirates.repository.PirateRepository;
import org.example.pirates.service.PirateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PirateServiceImpl implements PirateService {
    private final PirateRepository pirateRepository;

    @Override
    public void createPirate(Pirate pirate) {
        pirateRepository.save(pirate);
    }
    @Override
    public List<Pirate> getAllPirates(){
        return pirateRepository.findAll();
    }
    @Override
    public Pirate getPirateById(UUID id){
        return pirateRepository.findById(id).orElse(null);
    }
    @Override
    public void updatePirate(UUID id, Pirate pirate){
        Pirate existPirate = pirateRepository.getReferenceById(id);
        existPirate.setName(pirate.getName());
        existPirate.setBounty(pirate.getBounty());
        existPirate.setCrew(pirate.getCrew());
        existPirate.setIsAlive(pirate.getIsAlive());
        pirateRepository.save(existPirate);
    }
    @Override
    public Pirate deletePirate(UUID id){
        Pirate existPirate = pirateRepository.getReferenceById(id);
        pirateRepository.deleteById(id);
        return existPirate;
    }
}
