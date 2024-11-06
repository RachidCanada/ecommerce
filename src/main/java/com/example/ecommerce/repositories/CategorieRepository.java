package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
