package org.sid.gds.repository;

import org.sid.gds.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Roles, Integer> {

}
