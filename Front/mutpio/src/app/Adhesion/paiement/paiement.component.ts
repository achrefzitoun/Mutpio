import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem, MessageService } from 'primeng/api';
import { AdressePostale } from 'src/app/Models/AdressePostale';
import { Beneficiare } from 'src/app/Models/Beneficiare';
import { Devis } from 'src/app/Models/Devis';
import { Prospect } from 'src/app/Models/Prospect';
import { Regime } from 'src/app/Models/Regime';
import { TypeBeneficiare } from 'src/app/Models/TypeBeneficiare';
import { DatePipe } from '@angular/common';
import { Contact } from 'src/app/Models/Contact';
import { Formule } from 'src/app/Models/Formule';

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.css'],
  providers: [MessageService]
})
export class PaiementComponent implements OnInit {
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
  constructor(private messageService: MessageService, private router: Router, private datePipe: DatePipe) { }

  ngOnInit() {
    this.adresse.ville = "Ben Arous";
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
      situation: '',
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


    this.items = [
      {
        label: 'Information',
        routerLink: '/info'
      },
      {
        label: 'Mandat',
        routerLink: '/mondat'
      },
      {
        label: 'Paiement',
        routerLink: '/paiement'
      },
      {
        label: 'Signature',
        routerLink: '/signature'
      },
      {
        label: 'Confirmation',
        routerLink: '/confirmation'
      }
    ];

    setTimeout(() => {
      this.blockedPanel = true;
    }, 2);


  }

  onActiveIndexChange(event: number) {
    this.activeIndex = event;
  }

  load() {
    this.loading = true;
  }


  



}