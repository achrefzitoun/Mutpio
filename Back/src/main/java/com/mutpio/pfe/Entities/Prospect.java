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
public class Prospect implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProspect;

    String nom, prenom;

    @JsonFormat(pattern = "yyyy-MM-dd")
    LocalDate dateNaissance;

    @Enumerated(EnumType.STRING)
    Regime regime = Regime.GENERALE;

    Boolean PPE;

    @OneToMany(mappedBy = "prospect")
    Set<Devis> devis;

    @OneToOne(mappedBy = "prospect")
    Compte compte;

    @OneToOne(mappedBy = "prospect")
    Contact contact;

    @OneToOne(mappedBy = "prospect")
    AdressePostale adressePostale;

}
