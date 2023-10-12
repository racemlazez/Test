package com.projetOpticien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetOpticien.dao.VisiteRepository;
import com.projetOpticien.model.Visite;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class VisiteService {

	private final VisiteRepository visiteRepository;

	@Autowired
	public VisiteService(VisiteRepository visiteRepository) {
		super();
		this.visiteRepository = visiteRepository;
	}

	public List<Visite> getAllVisite() {
		return visiteRepository.findAll();
	}

	 public List<Visite> getVisiteByClientId (Long id){
	 return visiteRepository.findByVenteClientId(id);
	 }

	public List<Visite> getVisiteNonArchive() {
		return visiteRepository.findByIsDeletedFalse();
	}

	public void addVisite(Visite visite) {
		visiteRepository.saveAndFlush(visite);
	}

	public void deleteVisite(Long id) {
		visiteRepository.deleteById(id);
	}

	public void updateVisite(Visite newVisite, Long id) {

		Visite currentVisite = visiteRepository.findById(id).get();

		if (currentVisite != null) {

			currentVisite.setDate(newVisite.getDate());
			currentVisite.setHeure(newVisite.getHeure());
			currentVisite.setRefVisite(newVisite.getRefVisite());
			currentVisite.setMontantReçuParVisite(newVisite.getMontantReçuParVisite());

			visiteRepository.saveAndFlush(currentVisite);
		}

	}

	public void archiverVisite(Visite newVisite, Long id) {

		Visite currentVisite = visiteRepository.findById(id).get();
		if (currentVisite != null) {

			currentVisite.setIsDeleted(newVisite.getIsDeleted());
			visiteRepository.saveAndFlush(currentVisite);

		}

	}
}
