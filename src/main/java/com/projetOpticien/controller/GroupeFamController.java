package com.projetOpticien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetOpticien.model.Groupe_fam;
import com.projetOpticien.service.GroupeFamService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/groupes/")
public class GroupeFamController {
	
	private final GroupeFamService groupeFamService;

	@Autowired
	public GroupeFamController(GroupeFamService groupeFamService) {
		super();
		this.groupeFamService = groupeFamService;
	}
	
	@GetMapping("getAll")
    public List<Groupe_fam> findAll(){
    	return groupeFamService.getAllGroupe();
    }
	
	@PostMapping("addGrp")
	public void save(@RequestBody Groupe_fam groupe_fam) {
		groupeFamService.addGroupe(groupe_fam);
	}
	
	@PutMapping("editGrp/{id}")
	public void put(@RequestBody Groupe_fam groupe_fam, @PathVariable(value = "id") Long id) {
		groupeFamService.updateGroupe(groupe_fam, id);
	}
	
	@DeleteMapping("removeGrp/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		groupeFamService.deleteGroupe(id);
	}
	
	

}
