import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem, MessageService } from 'primeng/api';
import { Beneficiare } from 'src/app/Models/Beneficiare';
import { Devis } from 'src/app/Models/Devis';
import { Regime } from 'src/app/Models/Regime';
import { TypeBeneficiare } from 'src/app/Models/TypeBeneficiare';

@Component({
  selector: 'app-mondatdetails',
  templateUrl: './mondatdetails.component.html',
  styleUrls: ['./mondatdetails.component.css'],
  providers: [MessageService]
})
export class MondatdetailsComponent implements OnInit {
  items!: MenuItem[];
  activeIndex: number = 1;
  beneficiare !: Beneficiare;

  stateOptions: any[] = [{ label: 'Off', value: 'off' }, { label: 'On', value: 'on' }];

  value: string = 'off';

  selectedDate: string | null = null;

  checked: Boolean = false;

  open: Boolean = false;

  uploadedFiles: any[] = [];
  loading: boolean = false;

  constructor(private messageService: MessageService, private router: Router) { }


  ngOnInit(): void {
    window.scrollTo(0, 0);
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

  selectDate(date: string) {
    this.selectedDate = date;
  }

  load() {
    this.loading = true;
    setTimeout(() => {
      this.loading = false;
      this.router.navigate(['/paiement']);
    }, 2000);
  }

}
