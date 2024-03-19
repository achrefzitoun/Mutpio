import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { MenuItem } from 'primeng/api';
import { Devis } from 'src/app/Models/Devis';
import { Beneficiare } from 'src/app/Models/Beneficiare';
import { Prospect } from 'src/app/Models/Prospect';
import { TypeBeneficiare } from 'src/app/Models/TypeBeneficiare';
import { Regime } from 'src/app/Models/Regime';
import { Contact } from 'src/app/Models/Contact';
import { AdressePostale } from 'src/app/Models/AdressePostale';
import { Formule } from 'src/app/Models/Formule';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-signature',
  templateUrl: './signature.component.html',
  styleUrls: ['./signature.component.css']
})
export class SignatureComponent implements OnInit {

  constructor(private http: HttpClient, private datePipe: DatePipe) {

  }
  items!: MenuItem[];
  activeIndex: number = 1;
  loading: boolean = false;
  blockedPanel!: boolean;

  customers = [{}];

  beneficiare !: Beneficiare;
  devis: Devis = new Devis();
  prospect: Prospect = new Prospect();
  adresse: AdressePostale = new AdressePostale();
  contact: Contact = new Contact();
  formule: Formule = new Formule();

  ngOnInit() {

    this.adresse.ville = "Ben Arous";
    this.adresse.codePostale = 2013;
    this.adresse.adressePostale = "06 Zouheir Safi";

    this.contact.numTel = "+33 26 977 557";
    this.contact.email = "Achref.zitoun@tessi.fr";

    this.prospect.contact = this.contact;
    this.prospect.adressePostale = this.adresse;

    this.formule.formuleLabel = "SERENA 5";

    this.devis.formule = this.formule;
    this.devis.prospect = this.prospect;
    this.devis.dateAdhesion = new Date();

    this.beneficiare = {
      idBeneficiare: 1,
      numBeneficiare: '5962325',
      nom: 'Achref',
      prenom: 'Zitoun',
      noSs: '59632556659596',
      cleSs: '19',
      situation: 'Célibataire',
      nomJeuneFille: '',
      dateNaissance: new Date('2000-01-01'),
      dateClotureComptable: new Date('2022-01-01'),
      frontalier: false,
      parraine: false,
      femme: false,
      regime: Regime.TNS,
      typeBeneficiare: TypeBeneficiare.ENFANT,
      document: [],
      devis: this.devis
    };

  }


}
