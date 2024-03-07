package com.mutpio.pfe.Entities;


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

    LocalDate dateNaissance, dateClotureComptable;

    Boolean frontalier, parraine, femme;

    @Enumerated(EnumType.STRING)
    Regime regime;

    @Enumerated(EnumType.STRING)
    TypeBeneficiare typeBeneficiare;

    @OneToMany(mappedBy = "beneficiare")
    Set<Document> document;

    @ManyToOne
    Devis devis;
}
