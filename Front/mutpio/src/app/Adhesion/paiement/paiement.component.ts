import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MenuItem, MessageService } from 'primeng/api';

@Component({
  selector: 'app-paiement',
  templateUrl: './paiement.component.html',
  styleUrls: ['./paiement.component.css'],
  providers: [MessageService]
})
export class PaiementComponent implements OnInit{
  items!: MenuItem[];
  activeIndex: number = 1;
  loading: boolean = false;
  blockedPanel: boolean = false;

  constructor(private messageService: MessageService, private router: Router) { }

  ngOnInit(){
    
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

  load() {
    this.loading = true;
    setTimeout(() => {
      this.loading = false;
      this.router.navigate(['/paiement']);
    }, 2000);
  }

}
