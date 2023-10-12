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

import com.projetOpticien.model.Organisme;
import com.projetOpticien.service.OrganismeService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/organismes/")
public class OrganismeController {
	
	private final OrganismeService organismeService;

	@Autowired
	public OrganismeController(OrganismeService organismeService) {
		super();
		this.organismeService = organismeService;
	}
	
	@GetMapping("getAll")
    public List<Organisme> findAll(){
    	return organismeService.getAllOrganisme();
    }
	
	@PostMapping("addOrg")
	public void save(@RequestBody Organisme organisme) {
		organismeService.addOrganisme(organisme);
	}
	
	@PutMapping("editOrg/{id}")
	public void put(@RequestBody Organisme organisme, @PathVariable(value = "id") Long id) {
		organismeService.updateOrganisme(organisme, id);
	}
	
	@DeleteMapping("removeOrg/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
	   organismeService.deleteOrganisme(id);
	}
	
	
	

}
