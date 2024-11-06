package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Produit;
import com.example.ecommerce.repositories.ProduitRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitController {

    private final ProduitRepository produitRepository;

    public ProduitController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping
    public List<Produit> getAllProducts() {
        return produitRepository.findAll();
    }

    @GetMapping("/search")
    public List<Produit> searchProduits(@RequestParam String keyword) {
        return produitRepository.findByNomContaining(keyword);
    }
}
