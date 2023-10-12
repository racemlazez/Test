package com.projetOpticien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetOpticien.dao.GroupeFamRepository;
import com.projetOpticien.model.Groupe_fam;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class GroupeFamService {
	
	private final GroupeFamRepository groupeFamRepository;

	@Autowired
	public GroupeFamService(GroupeFamRepository groupeFamRepository) {
		super();
		this.groupeFamRepository = groupeFamRepository;
	}
	
	public List<Groupe_fam> getAllGroupe(){
		return groupeFamRepository.findAll();
    }
	
	public void addGroupe(Groupe_fam groupe_fam) {
		groupeFamRepository.saveAndFlush(groupe_fam);
	}
	
	
	public void deleteGroupe(Long id) {
		groupeFamRepository.deleteById(id);
	}
	
    public void updateGroupe(Groupe_fam newGroupe, Long id) {
		
    	Groupe_fam currentGroupe = groupeFamRepository.findById(id).get();
		
			if (currentGroupe != null) {
				
				currentGroupe.setNomFamille(newGroupe.getNomFamille());
				currentGroupe.setEmailResponsableGrp(newGroupe.getEmailResponsableGrp());
				currentGroupe.setAdresse(newGroupe.getAdresse());
				currentGroupe.setTeleRespGrp(newGroupe.getTeleRespGrp());
				currentGroupe.setRemise_grp(newGroupe.getRemise_grp());
				
				groupeFamRepository.saveAndFlush(currentGroupe);
			}
		

	}
	
	

}
