package com.example.ecommerce.controllers;

import com.example.ecommerce.entities.Utilisateur;
import com.example.ecommerce.repositories.UtilisateurRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/utilisateurs")
public class UtilisateurController {

    private static final Logger logger = LoggerFactory.getLogger(UtilisateurController.class);
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurController(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @PostMapping("/inscription")
    public ResponseEntity<?> inscrireUtilisateur(@Valid @RequestBody Utilisateur utilisateur) {
        try {
            if (utilisateurRepository.findByCourriel(utilisateur.getCourriel()).isPresent()) {
                return new ResponseEntity<>("Cet email est déjà utilisé", HttpStatus.CONFLICT);
            }
            Utilisateur nouvelUtilisateur = utilisateurRepository.save(utilisateur);
            return new ResponseEntity<>(nouvelUtilisateur, HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Erreur lors de l'inscription de l'utilisateur : ", e);
            return new ResponseEntity<>("Erreur interne du serveur", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getUtilisateur(@PathVariable Long id) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
        return utilisateur.map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}/modifier")
    public ResponseEntity<?> modifierUtilisateur(@PathVariable Long id, @Valid @RequestBody Utilisateur utilisateur) {
        Optional<Utilisateur> utilisateurExistant = utilisateurRepository.findById(id);
        if (utilisateurExistant.isPresent()) {
            Utilisateur u = utilisateurExistant.get();
            u.setPrenom(utilisateur.getPrenom());
            u.setNom(utilisateur.getNom());
            u.setDateNaissance(utilisateur.getDateNaissance());
            u.setTelephone(utilisateur.getTelephone());
            u.setCourriel(utilisateur.getCourriel());
            u.setMotDePasse(utilisateur.getMotDePasse());
            u.setAdresse(utilisateur.getAdresse());
            u.setVille(utilisateur.getVille());
            u.setProvince(utilisateur.getProvince());
            u.setPays(utilisateur.getPays());
            u.setCodePostal(utilisateur.getCodePostal());

            utilisateurRepository.save(u);
            return new ResponseEntity<>(u, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Utilisateur non trouvé", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> supprimerUtilisateur(@PathVariable Long id) {
        if (utilisateurRepository.existsById(id)) {
            utilisateurRepository.deleteById(id);
            return new ResponseEntity<>("Utilisateur supprimé avec succès", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Utilisateur non trouvé", HttpStatus.NOT_FOUND);
        }
    }
}
