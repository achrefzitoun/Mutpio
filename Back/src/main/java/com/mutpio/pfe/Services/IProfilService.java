package com.mutpio.pfe.Services;

import com.mutpio.pfe.Entities.Beneficiare;
import com.mutpio.pfe.Entities.ContratResiliation;
import com.mutpio.pfe.Entities.Devis;
import com.mutpio.pfe.Entities.Prospect;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface IProfilService {


    public Devis ajouterDevisAvecProspectEtContact(Devis devis);


    public void addProsAndBenef(Devis devis);


}
