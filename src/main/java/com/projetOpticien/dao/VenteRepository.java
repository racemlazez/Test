package com.projetOpticien.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetOpticien.model.Vente;

public interface VenteRepository extends JpaRepository<Vente, Long> {
	
}
