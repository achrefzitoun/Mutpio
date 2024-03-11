import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MenuItem, MessageService } from 'primeng/api';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-informations',
  templateUrl: './informations.component.html',
  styleUrls: ['./informations.component.css'],
  providers: [MessageService]
})
export class InformationsComponent implements OnInit {
  date: Date | undefined;
  items!: MenuItem[];
  subscription!: Subscription;
  isOutlined1: boolean = true;
  isOutlined2: boolean = true;
  isOutlined3: boolean = true;
  situations!: any[];
  selectedSituation!: any;
  value: boolean | null = null;
  civil: boolean = false;

  activeIndex: number = 0;

  constructor(public messageService: MessageService) { }
  
  ngOnInit() {
    this.isOutlined1 = false

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
        routerLink: 'personal'
      },
      {
        label: 'Mandat',
        routerLink: 'seat'
      },
      {
        label: 'Paiement',
        routerLink: 'payment'
      },
      {
        label: 'Signature',
        routerLink: 'confirmation'
      },
      {
        label: 'Confirmation',
        routerLink: 'confirmation'
      }
    ];

  }

  onActiveIndexChange(event: number) {
    this.activeIndex = event;
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

}
