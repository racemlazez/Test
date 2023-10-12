package com.projetOpticien.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetOpticien.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
