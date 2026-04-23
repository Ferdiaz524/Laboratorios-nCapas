package org.example.censohyrule;

import org.example.censohyrule.domain.entity.Material;
import org.example.censohyrule.service.MaterialService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CensoHyruleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CensoHyruleApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(MaterialService materialService) {

		return args -> {

			System.out.println("=== INICIANDO APP ===");
			materialService.findAll().forEach(p ->
					System.out.println(p.getNombre() + " - $" + p.getPrecio())
			);

			System.out.println("=== ORDENADO DE MAYOR A MENOR POR PRECIO ===");
			materialService.ordenarPorPrecio().forEach(p ->
					System.out.println("[HYRULE-DB] Nombre: " + p.getNombre() + " | Categoría: " + p.getCategoria()  + " | Precio: " + "$" + p.getPrecio() + " Rupias")
			);

			System.out.println("=== MATERIAL MAS CARO ===");

			Material masCaro = materialService.obtenerMasCaro();

			if (masCaro != null) {
				System.out.println("[HYRULE-DB] Nombre: " + masCaro.getNombre() + " | Categoría: " + masCaro.getCategoria()  + " | Precio: " + "$" + masCaro.getPrecio() + " Rupias");
			} else {
				System.out.println("[HYRULE-DB] No hay materiales disponibles");
			}

			System.out.println("=== MATERIALES DE GRADO LEGENDARIO ===");
			materialService.filtroLegendario().forEach(p ->
					System.out.println("[HYRULE-DB] Nombre: " + p.getNombre() + " | Categoría: " + p.getCategoria()  + " | Precio: " + "$" + p.getPrecio() + " Rupias")
			);

			System.out.println("=== LISTA DE TODAS LAS UBICACIONES REGISTRADAS ===");
			materialService.filtrarUbicacionesUnicas().forEach(p->
					System.out.println("[HYRULE-DB] " + p)
			);


		};
	}

}
