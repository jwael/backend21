package org.sid.gds.dto;



import org.sid.gds.model.Roles;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RolesDto {

	
	private Integer id;
	
	private String RoleName;
	
	private UtilisateurDto utilisateur;
	
	
	public static RolesDto fromEntity(Roles roles) {
		if(roles==null) {
			return null;
		}
		return RolesDto.builder()
				.id(roles.getId())
				.RoleName(roles.getRoleName())
				.build();
	}
}
