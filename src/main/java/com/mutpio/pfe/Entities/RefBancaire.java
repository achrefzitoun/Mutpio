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
public class RefBancaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idRefBancaire;

    String frequence, iban, bic, titulaire;

    @Enumerated(EnumType.STRING)
    TypeRef typeRef;

    Integer jourPrelevement;

    @ManyToOne
    Devis devis;


}
