package com.example.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Long> {

}
