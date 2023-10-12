package com.projetOpticien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetOpticien.dao.PointVenteRepository;
import com.projetOpticien.model.PointVente;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PointVenteService {
	
	private final PointVenteRepository pointVenteRepository;

	@Autowired
	public PointVenteService(PointVenteRepository pointVenteRepository) {
		super();
		this.pointVenteRepository = pointVenteRepository;
	}
	
	public List<PointVente> getAllPointVente(){
		return pointVenteRepository.findAll();
    }
	
	public void addPointVente(PointVente pointVente ) {
		pointVenteRepository.saveAndFlush(pointVente);
	}
	
	public void deletePointVente(Long id) {
		pointVenteRepository.deleteById(id);
	}
	
    public void updatePointVente(PointVente newPointVente, Long id) {
		
    	PointVente currentPointVente = pointVenteRepository.findById(id).get();
		
			if (currentPointVente != null) {
				
				currentPointVente.setAdresseBoutique(newPointVente.getAdresseBoutique());
				
				pointVenteRepository.saveAndFlush(currentPointVente);
			}
		

	}
	

}
