package org.sid.gds.repository;

import java.util.Optional;

import org.sid.gds.model.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeClientRepository extends JpaRepository <CommandeClient, Integer>{


	Optional<CommandeClient> findCommandeClientByCode(String code);
}
