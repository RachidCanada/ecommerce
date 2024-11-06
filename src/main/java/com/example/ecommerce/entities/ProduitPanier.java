package com.example.ecommerce.entities;

import jakarta.persistence.*;

@Entity
public class ProduitPanier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produit produit;

    private int quantite;

    @ManyToOne
    @JoinColumn(name = "panier_id")
    private Panier panier;

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }
}
