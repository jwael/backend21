package org.sid.gds.repository;

import java.util.Optional;

import org.sid.gds.dto.CommandeFournisseurDto;
import org.sid.gds.model.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeFournisseurRepository extends JpaRepository <CommandeFournisseur, Integer> {

	Optional<CommandeFournisseur> findCommandeFournisseurByCode(String code);

	

	CommandeFournisseur save(CommandeFournisseurDto entity);

}
