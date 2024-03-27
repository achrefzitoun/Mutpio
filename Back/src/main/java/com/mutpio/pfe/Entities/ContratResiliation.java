package com.mutpio.pfe.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class ContratResiliation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCompteRes;

    String nom, prenom, numContrat, organisme;

    Boolean etat = false;

    @OneToOne(cascade = CascadeType.ALL)
            @JsonIgnore
    Devis devis;

}
