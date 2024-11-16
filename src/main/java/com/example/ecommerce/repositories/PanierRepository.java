package com.example.ecommerce.repositories;


import com.example.ecommerce.entities.Panier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PanierRepository extends JpaRepository<Panier, Long> {
}
