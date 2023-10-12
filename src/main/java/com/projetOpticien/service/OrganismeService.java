package com.projetOpticien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetOpticien.dao.OrganismeRepository;
import com.projetOpticien.model.Organisme;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OrganismeService {
	
	private final OrganismeRepository organismeRepository;

	@Autowired
	public OrganismeService(OrganismeRepository organismeRepository) {
		super();
		this.organismeRepository = organismeRepository;
	}
	
	
	public List<Organisme> getAllOrganisme(){
		return organismeRepository.findAll();
    }
	
	
	
	public void addOrganisme(Organisme organisme) {
		organismeRepository.saveAndFlush(organisme);
	}
	
	
	public void deleteOrganisme(Long id) {
		organismeRepository.deleteById(id);
	}
	
	
    public void updateOrganisme(Organisme newOrganisme, Long id) {
		
    	Organisme currentOrganisme = organismeRepository.findById(id).get();
		
			if (currentOrganisme != null) {
				
				currentOrganisme.setNomOrganisme(newOrganisme.getNomOrganisme());
				currentOrganisme.setEmail(newOrganisme.getEmail());
				currentOrganisme.setAdresse(newOrganisme.getAdresse());
				currentOrganisme.setNumTelephone(newOrganisme.getNumTelephone());
				currentOrganisme.setMatriculeFiscale(newOrganisme.getMatriculeFiscale());
				currentOrganisme.setRemise_org(newOrganisme.getRemise_org());
				
				
				organismeRepository.saveAndFlush(currentOrganisme);
			}
		

	}
	


}
