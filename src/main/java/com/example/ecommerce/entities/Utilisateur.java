package com.example.ecommerce.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, max = 50)
    private String prenom;

    @NotNull
    @Size(min = 2, max = 50)
    private String nom;

    @Email
    @NotNull
    private String courriel;

    @NotNull
    private String motDePasse;

    private String adresse;
    private String ville;
    private String province;
    private String pays;
    private String codePostal;
    private String telephone;

    // Utilisation de LocalDate pour représenter la date
    private LocalDate dateNaissance;

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getCourriel() { return courriel; }
    public void setCourriel(String courriel) { this.courriel = courriel; }

    public String getMotDePasse() { return motDePasse; }
    public void setMotDePasse(String motDePasse) { this.motDePasse = motDePasse; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public String getProvince() { return province; }
    public void setProvince(String province) { this.province = province; }

    public String getPays() { return pays; }
    public void setPays(String pays) { this.pays = pays; }

    public String getCodePostal() { return codePostal; }
    public void setCodePostal(String codePostal) { this.codePostal = codePostal; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public LocalDate getDateNaissance() { return dateNaissance; }
    public void setDateNaissance(LocalDate dateNaissance) { this.dateNaissance = dateNaissance; }
}
