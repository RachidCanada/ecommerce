package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findByNomContaining(String keyword);
}
