import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem, MessageService } from 'primeng/api';

import { Beneficiare } from 'src/app/Models/Beneficiare';
import { Devis } from 'src/app/Models/Devis';
import { Regime } from 'src/app/Models/Regime';
import { TypeBeneficiare } from 'src/app/Models/TypeBeneficiare';

interface UploadEvent {
  originalEvent: Event;
  files: File[];
}

@Component({
  selector: 'app-informations',
  templateUrl: './informations.component.html',
  styleUrls: ['./informations.component.css'],
  providers: [MessageService]
})
export class InformationsComponent implements OnInit {
  items!: MenuItem[];

  situations!: any[];
  selectedSituation!: any;
  value: boolean | null = null;
  civil: boolean = false;
  uploadedFiles: any[] = [];

  activeIndex: number = 1;

  enfants!: Beneficiare[];
  beneficiare!: Beneficiare;
  conjoint!: Beneficiare;

  loading: boolean = false;

  stateOptions: any[] = [{label: 'M', value: 'off'}, {label: 'Mme', value: 'on'}];

  constructor(private messageService: MessageService, private router: Router) { }

  ngOnInit() {
    window.scrollTo(0, 0);
    this.enfants = [
      {
        idBeneficiare: 1,
        numBeneficiare: 'Numéro1',
        nom: 'Nom1',
        prenom: 'Prénom1',
        noSs: '',
        cleSs: '',
        situation: '',
        nomJeuneFille: '',
        dateNaissance: new Date('2000-01-01'),
        dateClotureComptable: new Date('2022-01-01'),
        frontalier: false,
        parraine: false,
        femme: false,
        regime: Regime.ALSACE_MOSELLE,
        typeBeneficiare: TypeBeneficiare.ENFANT,
        document: [],
        devis: new Devis
      },
      {
        idBeneficiare: 2,
        numBeneficiare: 'Numéro2',
        nom: 'Nom2',
        prenom: 'Prénom2',
        noSs: '',
        cleSs: '',
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
        devis: new Devis
      }
    ]

    this.beneficiare = {
      idBeneficiare: 1,
      numBeneficiare: 'benef',
      nom: 'benef',
      prenom: 'benef',
      noSs: '',
      cleSs: '',
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
      devis: new Devis
    };

    this.conjoint = {
      idBeneficiare: 1,
      numBeneficiare: 'conj',
      nom: 'Nom1',
      prenom: 'Prénom1',
      noSs: '',
      cleSs: '',
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
      devis: new Devis
    };

    this.situations = [
      { name: 'Célibataire', code: 'NY' },
      { name: 'Concubinage', code: 'RM' },
      { name: 'Marié', code: 'LDN' },
      { name: 'Pacsé', code: 'IST' },
      { name: 'Divorcé', code: 'PRS' },
      { name: 'Veuf', code: 'PRS' }
    ];

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
        routerLink: '/confirmation'
      },
      {
        label: 'Confirmation',
        routerLink: '/confirmation'
      }
    ];
  }

  onActiveIndexChange(event: number) {
    this.activeIndex = event;
  }

  isOutlined(expectedRegime: string, currentRegime: Regime): boolean {
    return !(currentRegime === expectedRegime);
  }

  load() {
    this.loading = true;
    setTimeout(() => {
      this.loading = false;
      this.router.navigate(['/mondat']);
    }, 2000);


  }

}
