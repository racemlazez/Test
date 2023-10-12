package com.projetOpticien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetOpticien.dao.CadreRepository;
import com.projetOpticien.model.Cadre;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CadreService {
	
	private final CadreRepository cadreRepository ;

	@Autowired
	public CadreService(CadreRepository cadreRepository) {
		super();
		this.cadreRepository = cadreRepository;
	}
	
	public List<Cadre> getAllCadre(){
		return cadreRepository.findAll();
    }
	
	public void addCadre(Cadre cadre) {
		cadreRepository.saveAndFlush(cadre);
	}
	
	public void deleteCadre(Long id) {
		cadreRepository.deleteById(id);
	}
	
    public void updateCadre(Cadre newCadre, Long id) {
		
    	Cadre currentCadre = cadreRepository.findById(id).get();
		
			if (currentCadre != null) {
				
				currentCadre.setMarque(newCadre.getMarque());
				currentCadre.setModele(newCadre.getModele());
				currentCadre.setPrix(newCadre.getPrix());
				
				
				
				cadreRepository.saveAndFlush(currentCadre);
			}
		

	}
	

}
