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
public class Prospect implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProspect;

    String nom, prenom;

    LocalDate dateNaissance;

    @Enumerated(EnumType.STRING)
    Regime regime;

    Boolean PPE;

    @OneToMany(mappedBy = "prospect")
    Set<Devis> devis;

    @OneToOne(mappedBy = "prospect")
    Compte compte;

    @OneToOne(mappedBy = "prospect")
    Contact contact;

}
