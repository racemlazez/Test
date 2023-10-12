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

import com.projetOpticien.model.Vendeur;
import com.projetOpticien.service.VendeurService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/vendeurs/")
public class VendeurController {
	
	private final VendeurService vendeurService;

	@Autowired
	public VendeurController(VendeurService vendeurService) {
		super();
		this.vendeurService = vendeurService;
	}
	
	@GetMapping("getAll")
	public List<Vendeur> findAll() {
		return vendeurService.getAllVendeur();
	}
	
	@PostMapping("addVendeur")
	public void save(@RequestBody Vendeur vendeur) {
		vendeurService.addVendeur(vendeur);
	}
	
	@PutMapping("editVendeur/{id}")
	public void put(@RequestBody Vendeur vendeur, @PathVariable(value = "id") Long id) {
		vendeurService.updateVendeur(vendeur, id);
	}
	
	@DeleteMapping("removeVendeur/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
	   vendeurService.deleteVendeur(id);
	}
	
	
	

}
