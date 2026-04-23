package org.example.censohyrule.common;

import org.example.censohyrule.domain.entity.Material;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MaterialList {
    private final List<Material> materials;

    public MaterialList() {
        this.materials = new ArrayList<>();

        this.materials.add(Material.builder()
                .id(1L)
                .nombre("Ámbar Rojo")
                .categoria("Mineral")
                .precio(30.00)
                .efecto("Estamina")
                .ubicacion("Desierto Gerudo")
                .grado("Raro")
                .build());

        this.materials.add(Material.builder()
                .id(2L)
                .nombre("Pimienta Ardiente")
                .categoria("Planta")
                .precio(10.00)
                .efecto("Ataque")
                .ubicacion("Cordillera de Hebra")
                .grado("Legendario")
                .build());

        this.materials.add(Material.builder()
                .id(3L)
                .nombre("Ala de Keese")
                .categoria("Parte de Monstruo")
                .precio(15.00)
                .efecto("Sigilo")
                .ubicacion("Cordillera de Hebra")
                .grado("Común")
                .build());
    }

    public List<Material> getMaterials() {
        return materials;
    }
}
