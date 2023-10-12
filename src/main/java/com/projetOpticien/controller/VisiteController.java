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

import com.projetOpticien.model.Visite;
import com.projetOpticien.service.VisiteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/visites/")
public class VisiteController {

	private final VisiteService visiteService;

	@Autowired
	public VisiteController(VisiteService visiteService) {
		super();
		this.visiteService = visiteService;
	}

	@GetMapping("getAll")
	public List<Visite> findAll() {
		return visiteService.getAllVisite();
	}

	@GetMapping("getVisitNonArchive")
	public List<Visite> findVisiteNonArchive() {
		return visiteService.getVisiteNonArchive();
	}

	 @GetMapping("getByClientId/{id}")
	public List<Visite> findByClient(@PathVariable(value = "id") Long id){
	 return visiteService.getVisiteByClientId(id);
	 }

	@PostMapping("addVisite")
	public void save(@RequestBody Visite visite) {
		visiteService.addVisite(visite);
	}

	@PutMapping("editVisite/{id}")
	public void put(@RequestBody Visite visite, @PathVariable(value = "id") Long id) {
		visiteService.updateVisite(visite, id);
	}

	@PutMapping("editVisiteNonArchive/{id}")
	public void putNonArchive(@RequestBody Visite visite, @PathVariable(value = "id") Long id) {
		visiteService.archiverVisite(visite, id);
	}

	@DeleteMapping("removeVisite/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
		visiteService.deleteVisite(id);
	}

}
