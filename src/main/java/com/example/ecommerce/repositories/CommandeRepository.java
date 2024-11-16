package com.example.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entities.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long>{

}
