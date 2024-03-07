package com.mutpio.pfe.Dto;

import com.mutpio.pfe.Entities.Regime;
import com.mutpio.pfe.Entities.TypeBeneficiare;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

@Value
public class BeneficiareDto implements Serializable {
    Long idBeneficiare;
    String numBeneficiare;
    String nom;
    String prenom;
    String noSs;
    String cleSs;
    String situation;
    String nomJeuneFille;
    LocalDate dateNaissance;
    LocalDate dateClotureComptable;
    Boolean frontalier;
    Boolean parraine;
    Boolean femme;
    Regime regime;
    TypeBeneficiare typeBeneficiare;
}