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
public class Signature implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSignature;

    String numSignature;

    Boolean isSigned;

    LocalDate dateSignature;

    @OneToOne
    Document contrat;

    @OneToOne
    Devis devis;
}
