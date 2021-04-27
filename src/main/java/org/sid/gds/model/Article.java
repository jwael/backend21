package org.sid.gds.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="article")
public class Article extends AbstractEntity {
	
	@Column(name="codearticle")
	private String codeArticle;
	
	@Column(name="designiation")
	private String designiation;
	
	@Column(name="prixunitairehT")
	private BigDecimal prixUnitaireHT;
	
	@Column(name="tauxtva")
	private BigDecimal tauxTva;
	
	@Column(name="prixunitairettc")
	private BigDecimal prixUnitaireTtc;
	
	@Column(name="photo")
	private String photo;
	
	@ManyToOne
	@JoinColumn(name="idcategory")
	private Category category;

}
