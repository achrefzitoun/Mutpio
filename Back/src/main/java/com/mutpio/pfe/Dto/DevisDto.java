package com.mutpio.pfe.Dto;

import com.mutpio.pfe.Entities.Etat;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 * DTO for {@link com.mutpio.pfe.Entities.Devis}
 */
@Value
public class DevisDto implements Serializable {
    Long idDevis;
    String numDevis;
    String besoinSpecifique;
    LocalDate dateAdhesion;
    LocalDate dateDevis;
    LocalDate dateExpiration;
    Double valDevis;
    Boolean retraite;
    Etat etat;
    Set<BeneficiareDto> beneficiares;
    SignatureDto signature;
}