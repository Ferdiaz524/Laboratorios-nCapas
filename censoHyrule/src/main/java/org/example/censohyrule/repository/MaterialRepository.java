package org.example.censohyrule.repository;

import lombok.RequiredArgsConstructor;
import org.example.censohyrule.common.MaterialList;
import org.example.censohyrule.domain.entity.Material;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MaterialRepository {
    private final MaterialList materialList;

    public List<Material> findAll(){
        return materialList.getMaterials();
    }
}
