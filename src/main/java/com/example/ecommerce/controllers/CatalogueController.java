package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Produit;
import com.example.ecommerce.repositories.ProduitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalogue")
@Validated
public class CatalogueController {
    private final ProduitRepository produitRepository;

    public CatalogueController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @PostMapping("/ajouter")
    public ResponseEntity<Produit> ajouterProduit(@Valid @RequestBody Produit produit) {
        Produit nouveauProduit = produitRepository.save(produit);
        return new ResponseEntity<>(nouveauProduit, HttpStatus.CREATED);
    }

    @GetMapping("/produits")
    public ResponseEntity<List<Produit>> getProduits() {
        List<Produit> produits = produitRepository.findAll();
        return new ResponseEntity<>(produits, HttpStatus.OK);
    }

    @PutMapping("/{id}/modifier")
    public ResponseEntity<Produit> modifierProduit(@PathVariable Long id, @Valid @RequestBody Produit produit) {
        Optional<Produit> produitExistant = produitRepository.findById(id);
        if (produitExistant.isPresent()) {
            Produit p = produitExistant.get();
            p.setNom(produit.getNom());
            p.setDescription(produit.getDescription());
            p.setPrix(produit.getPrix());
            produitRepository.save(p);
            return new ResponseEntity<>(p, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/supprimer")
    public ResponseEntity<Void> supprimerProduit(@PathVariable Long id) {
        if (produitRepository.existsById(id)) {
            produitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
