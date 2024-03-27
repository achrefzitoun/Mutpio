package com.mutpio.pfe.Controllers;

import com.mutpio.pfe.Entities.Beneficiare;
import com.mutpio.pfe.Entities.Devis;
import com.mutpio.pfe.Entities.Prospect;
import com.mutpio.pfe.Repositories.IBeneficiareRepository;
import com.mutpio.pfe.Repositories.IDevisRepository;
import com.mutpio.pfe.Services.IProfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profil")
@CrossOrigin(origins = "*")

public class ProfilRestController {

    public final IProfilService profilService;



    //C'est bon +- !!
    @PostMapping("/devis")
    public ResponseEntity<?> ajouterDevis(@RequestBody Devis devis) {
        try {
            Devis devisAjoute = profilService.ajouterDevisAvecProspectEtContact(devis);
            return ResponseEntity.ok(devisAjoute);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du devis: " + e.getMessage());
        }
    }






}
