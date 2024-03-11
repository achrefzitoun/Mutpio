import { Component, OnInit  } from '@angular/core';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit  {
  selectedRegime: string = '';
  valRadio: string = '';

  ngOnInit() {
    // Set the initial selected regime to 'general'
    this.selectedRegime = 'general';
  }

  selectRegime(regime: string) {
    this.selectedRegime = regime;
  }

}
