package org.sid.gds.model;

import java.time.Instant;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor 
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Entity
@Table(name="category")
public class Category extends AbstractEntity{
	
	
	@Column(name="code")
	private String code;
	
	@Column(name="designiation")
	private String designiation;
	
	@OneToMany(mappedBy="category")
	private List<Article> articles;

}
