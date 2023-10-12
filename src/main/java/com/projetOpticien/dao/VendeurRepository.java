package com.projetOpticien.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetOpticien.model.Vendeur;

public interface VendeurRepository extends JpaRepository<Vendeur, Long> {

}
