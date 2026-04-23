package org.example.censohyrule.service;

import lombok.RequiredArgsConstructor;
import org.example.censohyrule.domain.entity.Material;
import org.example.censohyrule.repository.MaterialRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialService {
    private final MaterialRepository materialRepository;

    public List<Material> findAll(){
        return  materialRepository.findAll();
    }

    public List<Material> ordenarPorPrecio() {
        return materialRepository.findAll().stream()
                .sorted((e1, e2) -> Double.compare(e2.getPrecio(), e1.getPrecio()))
                .toList();
    }

    public Material obtenerMasCaro() {
        return ordenarPorPrecio().stream()
                .findFirst()
                .orElse(null);
    }

    public List<Material> filtroLegendario() {
        return materialRepository.findAll().stream()
                .filter(obj -> obj.getGrado() == "Legendario")
                .toList();
    }

    public List<String> filtrarUbicacionesUnicas() {
        return materialRepository.findAll().stream()
                .map(Material::getUbicacion)
                .distinct()
                .toList();
    }
}
