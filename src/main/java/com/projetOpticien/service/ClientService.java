package com.projetOpticien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.projetOpticien.dao.ClientCriteriaRepository;
import com.projetOpticien.dao.ClientRepository;
import com.projetOpticien.model.Client;
import com.projetOpticien.model.ClientPage;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class ClientService {
	@Autowired
	private ClientCriteriaRepository clientCriteriaRepository  ;
	private final ClientRepository clientRepository;

	@Autowired
	public ClientService(ClientRepository clientRepository) {
		super();
		this.clientRepository = clientRepository;
	}
	
	public List<Client> getAllClient(){
    		return clientRepository.findAll();
    }
	
	public void addClient(Client client) {
    	clientRepository.saveAndFlush(client);
	}
	
	public void deleteClient(Long id) {
		clientRepository.deleteById(id);
	}
	
    public void updateClient(Client newClient, Long id) {
		
		Client currentClient = clientRepository.findById(id).get();
		
			if (currentClient != null) {
				
				currentClient.setReference(newClient.getReference());
				currentClient.setCin(newClient.getCin());
				currentClient.setNomPrenom(newClient.getNomPrenom());
				currentClient.setDateNaissance(newClient.getDateNaissance());
				currentClient.setAge(newClient.getAge());
				currentClient.setEmail(newClient.getEmail());
				currentClient.setAdresse(newClient.getAdresse());
				currentClient.setVille(newClient.getVille());
				currentClient.setPays(newClient.getPays());
				currentClient.setNumAssureSocial(newClient.getNumAssureSocial());
				currentClient.setNumTel1(newClient.getNumTel1());
				currentClient.setNumTel2(newClient.getNumTel2());
				currentClient.setGroupe(newClient.getGroupe());
				currentClient.setOrganisme(newClient.getOrganisme());
				currentClient.setChiffreAffaire(newClient.getChiffreAffaire());
				currentClient.setSolde(newClient.getSolde());
				
				clientRepository.saveAndFlush(currentClient);
			}
		

	}
	
    public Page<Client> getClient(ClientPage clientPage,
      		 String  clientSearchCriteria){
      return  clientCriteriaRepository.findAllWithFilters( clientPage,  clientSearchCriteria);}

}
