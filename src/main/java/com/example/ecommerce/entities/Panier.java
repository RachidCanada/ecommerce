package com.example.ecommerce.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Panier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL)
    private List<ProduitPanier> produits = new ArrayList<>();

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public List<ProduitPanier> getProduits() { return produits; }
    public void setProduits(List<ProduitPanier> produits) { this.produits = produits; }
}
