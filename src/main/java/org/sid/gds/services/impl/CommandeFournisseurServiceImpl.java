package org.sid.gds.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sid.gds.dto.CommandeClientDto;
import org.sid.gds.dto.CommandeFournisseurDto;
import org.sid.gds.dto.LigneCommandeFournisseurDto;
import org.sid.gds.exception.EntityNotFoundException;
import org.sid.gds.exception.ErrorCodes;
import org.sid.gds.exception.InvalidEntityException;
import org.sid.gds.model.Article;
import org.sid.gds.model.CommandeFournisseur;
import org.sid.gds.model.Fournisseur;
import org.sid.gds.model.LigneCommandeFournisseur;
import org.sid.gds.repository.ArticleRepository;
import org.sid.gds.repository.CommandeFournisseurRepository;
import org.sid.gds.repository.FournisseurRepository;
import org.sid.gds.repository.LigneCommandeFournisseurRepository;
import org.sid.gds.services.CommandeFournisseurService;
import org.sid.gds.validator.CommandeFournisseurValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

	private CommandeFournisseurRepository commandeFrounisseurRepository;	
	private FournisseurRepository fournisseurRepository;		
	private ArticleRepository articleRepository;
	private LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository;
	
	@Autowired
	public  CommandeFournisseurServiceImpl(CommandeFournisseurRepository commandeFrounisseurRepository,
			FournisseurRepository fournisseurRepository,ArticleRepository articleRepository,LigneCommandeFournisseurRepository ligneCommandeFournisseurRepository) {
		this.articleRepository=articleRepository;
		this.commandeFrounisseurRepository=commandeFrounisseurRepository;
		this.fournisseurRepository=fournisseurRepository;
		this.ligneCommandeFournisseurRepository=ligneCommandeFournisseurRepository;
	}
	
	@Override
	public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
		List<String> errors = CommandeFournisseurValidator.validate(dto);
		if(!errors.isEmpty()){
			log.error("");
			throw new InvalidEntityException ("Commandefournisseur n est pas  valide",ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
		}
		
		Optional<Fournisseur> client = fournisseurRepository.findById(dto.getFournisseur().getId());
		if(client==null) {
			log.error("client with id was not foundx", dto.getFournisseur().getId());
			throw new InvalidEntityException("aucun client avec id"+dto.getFournisseur().getId()+"n a pas ete trouve",ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND);
		}
		List<String> articleErrors = new ArrayList<>();
		if(dto.getLigneCommandeFournisseurs()!=null) {
			dto.getLigneCommandeFournisseurs().forEach(ligCmdFour->{
				if(ligCmdFour.getArticle()!=null) {
				Optional<Article> article = articleRepository.findById(ligCmdFour.getArticle().getId());
				if(article==null) {
					articleErrors.add("article avec id "+ ligCmdFour.getArticle().getId()+"n exciste pas");
				}
				}else {
					articleErrors.add("impossible d enregistrer une commande avec article null");
				}
				
			});
		}
				if(!articleErrors.isEmpty()) {
					log.error("article n excist pas dans la bdd");
					throw new InvalidEntityException("article n existe pas",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
				}
				
				CommandeFournisseur savedCmdFour = commandeFrounisseurRepository.save(CommandeFournisseurDto.toEntity(dto));
				if(dto.getLigneCommandeFournisseurs()!=null) {
					dto.getLigneCommandeFournisseurs().forEach(ligCmdFour->{
						LigneCommandeFournisseur ligneCommandeFournisseur = LigneCommandeFournisseurDto.toEntity(ligCmdFour);
						ligneCommandeFournisseur.setCommandeFournisseur(savedCmdFour);
						ligneCommandeFournisseurRepository.save(ligneCommandeFournisseur);
						
					});
				}
		
				
		return CommandeFournisseurDto.fromEntity(savedCmdFour);
		
	}

	@Override
	public CommandeFournisseurDto findById(Integer id) {
		if(id==null) {
			log.error("commandeFournisseur id is null");
			return null;
		}
		return commandeFrounisseurRepository.findById(id)
				.map(CommandeFournisseurDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException
						("aucun commandeFournisseur avec id"+id+ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND
								));
	}

	@Override
	public CommandeFournisseurDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			log.error("commandefournisseur id is null");
			return null;	
		}
		return commandeFrounisseurRepository.findCommandeFournisseurByCode(code)
				.map(CommandeFournisseurDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException (
						"aucun commandeFournisseur avec code"+code+ErrorCodes.COMMANDE_FOURNISSEUR_NOT_FOUND));
		
	}

	@Override
	public List<CommandeFournisseurDto> findAll() {
		return commandeFrounisseurRepository.findAll().stream()
				.map(CommandeFournisseurDto::fromEntity)
				.collect(Collectors.toList())
				;
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("commandeFournisseur id is null");
			return ;
		}
		commandeFrounisseurRepository.deleteById(id);
	}

}
