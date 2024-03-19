package com.mutpio.pfe.Controllers;

import com.mutpio.pfe.Entities.Beneficiare;
import com.mutpio.pfe.Entities.Devis;
import com.mutpio.pfe.Entities.Prospect;
import com.mutpio.pfe.Repositories.IBeneficiareRepository;
import com.mutpio.pfe.Repositories.IDevisRepository;
import com.mutpio.pfe.Services.IProfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    void addDevis(@ModelAttribute Devis devis) {
        profilService.addProsAndBenef(devis);
    }







}
