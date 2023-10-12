package com.projetOpticien.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetOpticien.model.User;



public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);

}
