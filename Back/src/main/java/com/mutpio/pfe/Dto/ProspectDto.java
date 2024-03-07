package com.mutpio.pfe.Dto;

import com.mutpio.pfe.Entities.Regime;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * DTO for {@link com.mutpio.pfe.Entities.Prospect}
 */
@Value
public class ProspectDto implements Serializable {
    String nom;
    String prenom;
    LocalDate dateNaissance;
    Regime regime;
}