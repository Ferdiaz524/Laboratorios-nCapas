package org.example.censohyrule.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Material {
    private Long id;
    private String nombre;
    private String categoria;
    private Double precio;
    private String efecto;
    private String ubicacion;
    private String grado;
}