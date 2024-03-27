package com.mutpio.pfe.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Compte implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idCompte;

    String email, password;

    LocalDate dateCreation;

    @Enumerated(EnumType.STRING)
    EtatCompte etatCompte;

    @OneToOne(cascade = CascadeType.ALL)
    Prospect prospect;
}
