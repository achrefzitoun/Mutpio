package com.mutpio.pfe.Services;

import com.mutpio.pfe.Entities.Beneficiare;
import com.mutpio.pfe.Entities.ContratResiliation;
import com.mutpio.pfe.Entities.Devis;
import com.mutpio.pfe.Entities.Prospect;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IProfilService {

    public void addProspectAndBeneficiaire(Prospect prospect , String email , LocalDate dateAdhesion);

    public Beneficiare addConjoint(Beneficiare beneficiare);
    public List<Beneficiare> addEnfants(List<Beneficiare> enfants);
    public ContratResiliation addContratResiliation (ContratResiliation contratResiliation);

    public void addProsAndBenef(Devis devis);

    public void ajouterDevisAvecProspectEtContact(Devis devis);


    public Prospect addProsp(Prospect prospect);


}
