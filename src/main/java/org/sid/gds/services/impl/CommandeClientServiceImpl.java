package org.sid.gds.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.sid.gds.dto.CommandeClientDto;
import org.sid.gds.dto.LigneCommandeClientDto;
import org.sid.gds.exception.EntityNotFoundException;
import org.sid.gds.exception.ErrorCodes;
import org.sid.gds.exception.InvalidEntityException;
import org.sid.gds.model.Article;
import org.sid.gds.model.Client;
import org.sid.gds.model.CommandeClient;
import org.sid.gds.model.LigneCommandeClient;
import org.sid.gds.repository.ArticleRepository;
import org.sid.gds.repository.ClientRepository;
import org.sid.gds.repository.CommandeClientRepository;
import org.sid.gds.repository.LigneCommandeClientRepository;
import org.sid.gds.services.CommandeClientService;
import org.sid.gds.validator.CommandeClientValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CommandeClientServiceImpl implements CommandeClientService{

	private CommandeClientRepository commandeClientRepository;	
	private ClientRepository clientRepository;		
	private ArticleRepository articleRepository;
	private LigneCommandeClientRepository ligneCommandeClientRepository;
	
	@Autowired
	public CommandeClientServiceImpl(CommandeClientRepository commandeClientRepository,
			ClientRepository clientRepository ,ArticleRepository articleRepository,LigneCommandeClientRepository ligneCommandeClientRepository) {
		this.commandeClientRepository=commandeClientRepository;
		this.articleRepository=articleRepository;
		this.clientRepository=clientRepository;
		this.ligneCommandeClientRepository=ligneCommandeClientRepository;
	}
	
	
	@Override
	public CommandeClientDto save(CommandeClientDto dto) {
		List<String> errors = CommandeClientValidator.validate(dto);
		if(!errors.isEmpty()) {
			log.error("CommandeClient n est pas valid");
			throw new InvalidEntityException("la commande n est pas valide",ErrorCodes.COMMANDE_CLIENT_NOT_VALID);
		}
		Optional<Client> client = clientRepository.findById(dto.getClient().getId());
			if(client==null) {
				log.error("id client is null");
				throw new EntityNotFoundException("aucun client avec id"+dto.getClient().getId()+"n a ete trouve",ErrorCodes.CLIENT_NOT_FOUND);			
			}
			List<String> articleErrors= new ArrayList<>();
			if(dto.getLigneCommandeClients() !=null) {
				dto.getLigneCommandeClients().forEach(ligCmdClt ->{
					if(ligCmdClt.getArticle() !=null) {
				   Optional <Article> article = articleRepository.findById(ligCmdClt.getArticle().getId());
				   if(article != null) {
					   articleErrors.add("l article avec l id "+ligCmdClt.getArticle().getId()+"n existe pas");
				   }
				   	} else {
				   		articleErrors.add("impossible d enregister les commandes avec un article null");
				   	}
					
				});
			}
				
				if(!articleErrors.isEmpty()) {
					log.warn("");
					throw new InvalidEntityException("article n exist pas ",ErrorCodes.ARTICLE_NOT_FOUND,articleErrors);
				}
				
				CommandeClient savedCmdClt  = commandeClientRepository.save(CommandeClientDto.toEntity(dto));
				
				if(dto.getLigneCommandeClients() !=null) {
					dto.getLigneCommandeClients().forEach(ligCmdClt ->{
						LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
						ligneCommandeClient.setCommandeClient(savedCmdClt);
						ligneCommandeClientRepository.save(ligneCommandeClient);
						
					});
				}
				
			return CommandeClientDto.fromEntity(savedCmdClt);
	}

	@Override
	public CommandeClientDto findById(Integer id) {
		if(id==null) {
			log.error("commandeclient id is null");
			return null;
		}
		return commandeClientRepository.findById(id)
				.map(CommandeClientDto::fromEntity)
				.orElseThrow(() -> new EntityNotFoundException (
						"aucune commandeclient trouve"+ id,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
						));
						
	}

	@Override
	public CommandeClientDto findByCode(String code) {
		if(!StringUtils.hasLength(code)) {
			log.error("commandeclient code id is null");
			return null;
		}
		return commandeClientRepository.findCommandeClientByCode(code)
		.map(CommandeClientDto::fromEntity)
		.orElseThrow(() -> new EntityNotFoundException (
				"aucune commandeclient trouve avec le code"+ code,ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
				));
	}

	@Override
	public List<CommandeClientDto> findAll() {
		
		return commandeClientRepository.findAll().stream()
				.map(CommandeClientDto :: fromEntity)
				.collect(Collectors.toList());	
				
	}

	@Override
	public void delete(Integer id) {
		if(id==null) {
			log.error("commande client id is null");
			return ;
		}
		commandeClientRepository.deleteById(id);
	}

}
