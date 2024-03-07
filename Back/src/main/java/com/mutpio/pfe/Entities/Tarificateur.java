package com.mutpio.pfe.Entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Tarificateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTarificateur")
    Long id;

    @Column(name = "IdFormule")
    Long idForume;

    @Column(name = "TAR_CODE")
    private String codeTarification;

    @Column(name = "TYPE_TAR")
    String typeTarification;

    @Column(name = "Regime")
    @Enumerated(EnumType.STRING)
    Regime regime;

    Boolean surComplementaire, statusRetraite;

    @Column(name = "AgeLimiteAdhesion")
    Integer ageLimiteAdhesion;

    @Column(name = "NbrAdult")
    Integer nbrAdult;

    @Column(name = "NbrEnfant")
    Integer nbrEnfant;

    @Column(name = "Age_De")
    Integer ageDe;

    @Column(name = "Age_A")
    Integer ageA;

    @Column(name = "Cotisation")
    Double cotisation;
}
