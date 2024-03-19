import { Component } from '@angular/core';
 
@Component({
  selector: 'app-besoins',
  templateUrl: './besoins.component.html',
  styleUrls: ['./besoins.component.css']
})
export class BesoinsComponent {
 
  value1!: number;
  value2!: number;
  value3!: number;
  value4!: number;
  value5!: number;

  loading: boolean = false;

 
   
  Besoin1: any[] = [
      { name: '1', value1: 1 },
      { name: '2', value1: 2 },
      { name: '3', value1: 3 },
      { name: '4', value1: 4 },
      { name: '5', value1: 5 },
 
  ];
 
  Besoin2: any[] = [
    { name: '1', value2: 1 },
    { name: '2', value2: 2 },
    { name: '3', value2: 3 },
    { name: '4', value2: 4 },
    { name: '5', value2: 5 },
 
  ];
 
  Besoin3: any[] = [
    { name: '0', value3: 0 },
    { name: '1', value3: 1 },
    { name: '2', value3: 2 },
    { name: '3', value3: 3 },
    { name: '4', value3: 4 },
    { name: '5', value3: 5 },
 
  ];
 
  Besoin4: any[] = [
    { name: '0', value4: 0 },
    { name: '1', value4: 1 },
    { name: '2', value4: 2 },
    { name: '3', value4: 3 },
    { name: '4', value4: 4 },
    { name: '5', value4: 5 },
 
  ];
 
  Besoin5: any[] = [
    { name: '0', value5: 0 },
    { name: '1', value5: 1 },
    { name: '2', value5: 2 },
    { name: '3', value5: 3 },
    { name: '4', value5: 4 },
    { name: '5', value5: 5 },
 
  ];
 
  load() {
    this.loading = true;

    setTimeout(() => {
      this.loading = false
    }, 2000);
  }

 
}