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

import com.projetOpticien.model.Verre;
import com.projetOpticien.service.VerreService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/verres/")
public class VerreController {
	
	private final VerreService verreService ;

	@Autowired
	public VerreController(VerreService verreService) {
		super();
		this.verreService = verreService;
	}
	
	@GetMapping("getAll")
    public List<Verre> findAll(){
    	return verreService.getAllVerre();
    }
	
	@PostMapping("addVerre")
	public void save(@RequestBody Verre verre) {
		verreService.addVerre(verre);
	}
	
	@PutMapping("editVerre/{id}")
	public void put(@RequestBody Verre verre, @PathVariable(value = "id") Long id) {
		verreService.updateVerre(verre, id);
	}
	
	@DeleteMapping("removeVerre/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
	   verreService.deleteVerre(id);
	}
	
	

}
