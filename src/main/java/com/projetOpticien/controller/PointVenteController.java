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

import com.projetOpticien.model.PointVente;
import com.projetOpticien.service.PointVenteService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/PV/")
public class PointVenteController {

	private final PointVenteService pointVenteService;

	@Autowired
	public PointVenteController(PointVenteService pointVenteService) {
		super();
		this.pointVenteService = pointVenteService;
	}
	
	@GetMapping("getAll")
    public List<PointVente> findAll(){
    	return pointVenteService.getAllPointVente();
    }
	
	@PostMapping("addPV")
	public void save(@RequestBody PointVente pointVente) {
		pointVenteService.addPointVente(pointVente);
	}
	
	@PutMapping("editPV/{id}")
	public void put(@RequestBody PointVente pointVente, @PathVariable(value = "id") Long id) {
		pointVenteService.updatePointVente(pointVente, id);
	}
	
	@DeleteMapping("removePV/{id}")
	public void delete(@PathVariable(value = "id") Long id) {
	   pointVenteService.deletePointVente(id);
	}
	
	
}
