package com.projetOpticien.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetOpticien.model.Verre;

public interface VerreRepository extends JpaRepository<Verre, Long> {

}
