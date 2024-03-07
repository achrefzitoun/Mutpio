package com.mutpio.pfe.Entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PaiementDetails extends AbstractPersistable<Long> implements Serializable {

    @Column(name = "mac")
    private String mac;

    @Column(name = "datePaiement")
    private LocalDateTime datePaiement;

    @Column(name = "tpe")
    private String tpe;

    @Column(name = "montant")
    private Double montant;

    @Column(name = "currency")
    private String currency;

    @Column(name = "reference")
    private String reference;

    @Column(name = "texteLibre")
    private String texteLibre;

    @Column(name = "codeRetour")
    private String codeRetour;

    @Column(name = "cvx")
    private String cvx;

    @Column(name = "vld")
    private String vld;

    @Column(name = "brand")
    private String brand;

    @Column(name = "status3ds")
    private String status3ds;

    @Column(name = "numauto")
    private String numauto;

    @Column(name = "motifrefus")
    private String motifrefus;

    @Column(name = "originecb")
    private String originecb;

    @Column(name = "veres")
    private String veres;

    @Column(name = "pares")
    private String pares;

    @Column(name = "montantech")
    private String montantech;

    @Column(name = "filtragecause")
    private String filtragecause;

    @Column(name = "filtragevaleur")
    private String filtragevaleur;

    @Column(name = "cbenregistree")
    private String cbenregistree;

    @Column(name = "cbmasquee")
    private String cbmasquee;

    @Column(name = "modepaiement")
    private String modepaiement;

    @Column(name= "authentification")
    private String authentification;

    @OneToOne
    Devis devis;
}
