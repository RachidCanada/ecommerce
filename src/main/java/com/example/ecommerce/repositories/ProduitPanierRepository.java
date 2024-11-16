package com.example.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ecommerce.entities.ProduitPanier;

public interface ProduitPanierRepository extends JpaRepository<ProduitPanier, Long>{

}
