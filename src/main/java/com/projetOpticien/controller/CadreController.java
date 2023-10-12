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

import com.projetOpticien.model.Cadre;
import com.projetOpticien.service.CadreService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/cadres/")
public class CadreController {
	
	private final CadreService cadreService ;

	@Autowired
	public CadreController(CadreService cadreService) {
		super();
		this.cadreService = cadreService;
	}
	
	@GetMapping("getAll")
    public List<Cadre> findAll(){
    	return cadreService.getAllCadre();
    }
	
	@PostMapping("addCadre")
	public void save(@RequestBody Cadre cadre) {
		cadreService.addCadre(cadre);
	}
	
	@PutMapping("editCadre/{id}")
	public void put(@RequestBody Cadre cadre, @PathVariable(value = "id") Long id) {
		cadreService.updateCadre(cadre, id);
	}
	
	@DeleteMapping("removeCadre/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
	   cadreService.deleteCadre(id);
	}
	
	

}
