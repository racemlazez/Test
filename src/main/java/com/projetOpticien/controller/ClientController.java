package com.projetOpticien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projetOpticien.model.Client;
import com.projetOpticien.model.ClientPage;
import com.projetOpticien.service.ClientService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/clients/")
public class ClientController {
	
	private final ClientService clientService;

	@Autowired
	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}
	
	@GetMapping("getAll")
    public List<Client> findAll(){
    	return clientService.getAllClient();
    }
	
	@PostMapping("addClient")
	public void save(@RequestBody Client client) {
		clientService.addClient(client);
	}
	
	@PutMapping("editClient/{id}")
	public void put(@RequestBody Client client, @PathVariable(value = "id") Long id) {
		clientService.updateClient(client, id);
	}
	
	@DeleteMapping("removeClient/{id}")
	public void deleteUser(@PathVariable(value = "id") Long id) {
		clientService.deleteClient(id);
	}
	
	@GetMapping("search")
	public ResponseEntity<Page<Client>> getClientt( ClientPage clientPage,@RequestParam String clientSearchCriteria) {
		return new ResponseEntity<>(clientService.getClient(clientPage, clientSearchCriteria), HttpStatus.OK);
	}

}
