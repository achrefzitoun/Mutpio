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
public class AdressePostale implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAdressePostale;

    String adressePostale;

    String ville;

    @OneToOne(cascade = CascadeType.ALL)
    Prospect prospect;


}
