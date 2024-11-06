package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Panier;
import com.example.ecommerce.entities.ProduitPanier;
import com.example.ecommerce.repositories.PanierRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/panier")
public class PanierController {
    private final PanierRepository panierRepository;

    public PanierController(PanierRepository panierRepository) {
        this.panierRepository = panierRepository;
    }

    // Endpoint pour obtenir un panier par ID
    @GetMapping("/{id}")
    public ResponseEntity<Panier> getPanier(@PathVariable Long id) {
        return panierRepository.findById(id)
            .map(panier -> new ResponseEntity<>(panier, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint pour ajouter un produit dans un panier existant
    @PostMapping("/{id}/ajouter")
    public ResponseEntity<Panier> ajouterProduit(@PathVariable Long id, @RequestBody ProduitPanier produitPanier) {
        return panierRepository.findById(id).map(panier -> {
            // Associer le produit au panier
            produitPanier.setPanier(panier);
            panier.getProduits().add(produitPanier);
            panierRepository.save(panier);
            return new ResponseEntity<>(panier, HttpStatus.OK);
        }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
