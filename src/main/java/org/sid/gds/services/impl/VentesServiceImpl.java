package org.sid.gds.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.sid.gds.dto.LigneVenteDto;
import org.sid.gds.dto.VentesDto;
import org.sid.gds.exception.EntityNotFoundException;
import org.sid.gds.exception.ErrorCodes;
import org.sid.gds.exception.InvalidEntityException;
import org.sid.gds.model.Article;
import org.sid.gds.model.LigneVente;
import org.sid.gds.model.Ventes;
import org.sid.gds.repository.ArticleRepository;
import org.sid.gds.repository.LigneVenteRepository;
import org.sid.gds.repository.VentesRepository;
import org.sid.gds.services.VentesService;
import org.sid.gds.validator.VentesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VentesServiceImpl implements VentesService {

	private ArticleRepository articleRepository;
	private VentesRepository ventesRepository;
	private LigneVenteRepository ligneVenteRepository;
	
	@Autowired
	public VentesServiceImpl(ArticleRepository articleRepository,VentesRepository ventesRepository,LigneVenteRepository ligneVenteRepository)
	{
		this.articleRepository=articleRepository;
		this.ventesRepository=ventesRepository;
		this.ligneVenteRepository=ligneVenteRepository;
	}
	
	@Override
	public VentesDto save(VentesDto dto) {
		List<String> errors = VentesValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("Ventes  nest pas valide ");
			throw new InvalidEntityException("",ErrorCodes.VENTES_NOT_FOUND,errors);	
		}
		
		List<String> articleErrors  = new ArrayList<>();	
		dto.getLigneVentes().forEach(ligneVenteDto->{
			Optional<Article> article  = articleRepository.findById(ligneVenteDto.getArticle().getId());
			if(article.equals(null)) {
				articleErrors.add("aucun article avec id "+ ligneVenteDto.getArticle().getId()+"n a ete trouve");
			}
		});
		if(!articleErrors.isEmpty()) {
			log.error("one or more article were not found in the db, {}",errors);
			throw new InvalidEntityException("",ErrorCodes.VENTES_NOT_FOUND,errors);
		}
		Ventes savedVentes = ventesRepository.save(VentesDto.toEntity(dto));
		dto.getLigneVentes().forEach(ligneVenteDto->{
			LigneVente ligneVente = LigneVenteDto.toEntity(ligneVenteDto);
			ligneVente.setVentes(savedVentes);
			ligneVenteRepository.save(ligneVente);
		});
		
		return VentesDto.fromEntity(savedVentes);
	}

	@Override
	public VentesDto findById(Integer id) {
		if(id==null) {
			log.error("vente id is null");
			return null;
		}
		return ventesRepository.findById(id)
				.map(VentesDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException
						("aucun vente n a ete trouve dans la bdd",ErrorCodes.VENTES_NOT_FOUND));
	}

	@Override
	public VentesDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			log.error("vente code is null");
			return null;
		}
		return ventesRepository.findVentesByCode(code)
				.map(VentesDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException(
						"aucune vente n a ete trouve",ErrorCodes.VENTES_NOT_FOUND
	));
	}

	@Override
	public List<VentesDto> findAll() {
		return ventesRepository.findAll().stream()
				.map(VentesDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("vente id is null");
			return;
		}
		ventesRepository.deleteById(id);
	}

}
