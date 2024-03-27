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
public class Devis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idDevis;

    String numDevis, besoinSpecifique;

    LocalDate dateAdhesion;

    LocalDate dateDevis;

    LocalDate dateExpiration;

    Double valDevis;

    Boolean retraite;

    @Enumerated(EnumType.STRING)
    Etat etat;

    @OneToMany(mappedBy = "devis")
    Set<Beneficiare> beneficiares;

    @OneToOne(mappedBy = "devis")
    Signature signature;

    @OneToMany(mappedBy = "devis")
    Set<RefBancaire> refBancaire;

    @ManyToOne
    Prospect prospect;

    @OneToOne(mappedBy = "devis")
    ContratResiliation contratResiliation;

    @ManyToOne
    Formule formule;

    @OneToOne(mappedBy = "devis")
    PaiementDetails paiementDetails;

}
