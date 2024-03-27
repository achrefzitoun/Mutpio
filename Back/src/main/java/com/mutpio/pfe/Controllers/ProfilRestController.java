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
    private final IBeneficiareRepository iBeneficiareRepository;

    @PostMapping("/addPros")
    void addProspectAndBeneficiaire(@ModelAttribute Prospect prospect , @RequestParam("naissance") String naissance , @RequestParam("adhesion") String adhesion , @RequestParam("email") String email){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate naiss = LocalDate.parse(naissance, formatter);
        LocalDate adh = LocalDate.parse(adhesion, formatter);

        prospect.setDateNaissance(naiss);

        profilService.addProspectAndBeneficiaire(prospect,email, adh);

    }

    @PostMapping("/addConjoint")
    Beneficiare addConjoint(@ModelAttribute Beneficiare conjoint , @RequestParam("naissance") String naissance ){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate naiss = LocalDate.parse(naissance, formatter);
        conjoint.setDateNaissance(naiss);

        return profilService.addConjoint(conjoint);

    }

    @PostMapping("/addEnfants")
    List<Beneficiare> addEnfants(@RequestBody  List<Beneficiare> enfants , @RequestParam("naissance") String naissance ){

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate naiss = LocalDate.parse(naissance, formatter);

        for(Beneficiare b : enfants){
            b.setDateNaissance(naiss);
        }
        return profilService.addEnfants(enfants);
    }


    @PostMapping("/add")
    public ResponseEntity<String> addDevis(@RequestBody Devis devis) {
        try {
            profilService.addProsAndBenef(devis);
            return ResponseEntity.status(HttpStatus.OK).body("Devis ajouté avec succès");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de l'ajout : " + e.getMessage());
        }
    }

    @PostMapping("/devis")
    public ResponseEntity<String> ajouterDevis(@RequestBody Devis devis , @RequestParam("adhesion") String adhesion) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(adhesion, formatter);
            devis.setDateAdhesion(localDate);
            profilService.ajouterDevisAvecProspectEtContact(devis);
            return ResponseEntity.ok("Devis ajouté avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du devis: " + e.getMessage());
        }
    }


    @PostMapping("/prosp")
    public ResponseEntity<String> addProspect(@RequestBody Prospect prospect, @RequestParam("naissance") String naissance) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(naissance, formatter);
            prospect.setDateNaissance(localDate);
           profilService.addProsp(prospect);
            return ResponseEntity.ok("Prosp ajouté avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erreur lors de l'ajout du prospect: " + e.getMessage());
        }
    }




}
