package com.mutpio.pfe.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.antlr.v4.runtime.misc.NotNull;

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
    Regime regime = Regime.GENERALE;

    boolean PPE;

    @OneToMany(mappedBy = "prospect")
    @JsonIgnore
    Set<Devis> devis;

    @OneToOne(mappedBy = "prospect" )
    @JsonIgnore
    Compte compte;

    @OneToOne(mappedBy = "prospect")
    Contact contact;

    @OneToOne(mappedBy = "prospect")
    AdressePostale adressePostale ;

}
