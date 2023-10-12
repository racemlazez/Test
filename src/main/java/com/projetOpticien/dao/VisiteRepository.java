package com.projetOpticien.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetOpticien.model.Visite;

public interface VisiteRepository extends JpaRepository<Visite, Long> {
	
	//List<Visite> findByClientId(Long id);
	List<Visite> findByIsDeletedFalse();
	//@Query("SELECT visite FROM Visite visite LEFT JOIN visite.ventes vt JOIN Client c ON c.id = :id ")
	//@Query("FROM Visite visite LEFT JOIN visite.ventes vt JOIN Client c ON c.id = vt.client.id WHERE c.id = :id ")
	List<Visite> findByVenteClientId(Long id);

}
