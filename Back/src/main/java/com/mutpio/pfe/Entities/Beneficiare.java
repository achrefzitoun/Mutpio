package com.mutpio.pfe.Entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Beneficiare implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBeneficiare;

    String numBeneficiare, nom, prenom, noSs, cleSs, situation, nomJeuneFille;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateNaissance;

    LocalDate dateClotureComptable;

    Boolean frontalier, parraine, femme;

    @Enumerated(EnumType.STRING)
    Regime regime = Regime.GENERALE;

    @Enumerated(EnumType.STRING)
    TypeBeneficiare typeBeneficiare;

    @OneToMany(mappedBy = "beneficiare")
    Set<Document> document;

    @ManyToOne
    Devis devis;
}
