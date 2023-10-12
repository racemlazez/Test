package com.projetOpticien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetOpticien.dao.VendeurRepository;
import com.projetOpticien.model.Vendeur;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VendeurService {
	
	private final VendeurRepository vendeurRepository;

	
	@Autowired
	public VendeurService(VendeurRepository vendeurRepository) {
		super();
		this.vendeurRepository = vendeurRepository;
	}
	
	
	public List<Vendeur> getAllVendeur(){
		return vendeurRepository.findAll();
    }
	
	public void addVendeur(Vendeur vendeur) {
		vendeurRepository.saveAndFlush(vendeur);
	}
	
	public void deleteVendeur(Long id) {
		vendeurRepository.deleteById(id);
	}
	
	 public void updateVendeur(Vendeur newVendeur, Long id) {
			
	    	Vendeur currentVendeur = vendeurRepository.findById(id).get();
			
				if (currentVendeur != null) {
					
					currentVendeur.setNomPrenom(newVendeur.getNomPrenom());
					currentVendeur.setNumTel(newVendeur.getNumTel());
					currentVendeur.setEmail(newVendeur.getEmail());
					currentVendeur.setAdresse(newVendeur.getAdresse());
					
					
					
					vendeurRepository.saveAndFlush(currentVendeur);
				}
			

		}
	
	

}
