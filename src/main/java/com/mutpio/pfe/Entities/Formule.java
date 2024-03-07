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
public class Formule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "formule_label")
    String formuleLabel;

    @Column(name = "formule_price")
    Double formulePrice;

    @Column(name = "date_derniere_modification")
    LocalDate dateDerniereModification;

    @Column(name = "Desc_formule")
    String descFormule;

    @OneToMany(mappedBy = "formule")
    Set<Devis> devis;

    @ManyToMany
    Set<RisqueLevel> risqueLevels;



}
