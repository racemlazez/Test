package com.projetOpticien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetOpticien.dao.VerreRepository;
import com.projetOpticien.model.Verre;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VerreService {
	
	private final VerreRepository verreRepository;

	@Autowired
	public VerreService(VerreRepository verreRepository) {
		super();
		this.verreRepository = verreRepository;
	}
	
	public List<Verre> getAllVerre(){
		return verreRepository.findAll();
    }
	
	public void addVerre(Verre verre) {
		verreRepository.saveAndFlush(verre);
	}
	
	public void deleteVerre(Long id) {
		verreRepository.deleteById(id);
	}
	
    public void updateVerre(Verre newVerre, Long id) {
		
    	Verre currentVerre = verreRepository.findById(id).get();
		
			if (currentVerre != null) {
				
				currentVerre.setRef_verre(newVerre.getRef_verre());
				currentVerre.setDesignation(newVerre.getDesignation());
				currentVerre.setVision(newVerre.getVision());
				currentVerre.setOeil(newVerre.getOeil());
				currentVerre.setPrisme(newVerre.getPrisme());
				currentVerre.setPeniche(newVerre.getPeniche());
				currentVerre.setBase(newVerre.getBase());
				currentVerre.setSph(newVerre.getSph());
				currentVerre.setCyl(newVerre.getCyl());
				currentVerre.setAddition(newVerre.getAddition());
				currentVerre.setAxe(newVerre.getAxe());
				
				
				verreRepository.saveAndFlush(currentVerre);
			}
		

	}
	

}
