package org.sid.gds.repository;

import java.util.Optional;

import org.sid.gds.model.Ventes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentesRepository extends JpaRepository <Ventes,Integer>{

	
	Optional<Ventes> findVentesByCode(String  code);
}
