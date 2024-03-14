import { Component, OnInit  } from '@angular/core';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit  {
  selectedRegime: string = '';
  valRadio: string = '';
  css: boolean = false;
  visible = false;
  ppe: boolean = false;
  conjoint: boolean = false;
  valueKnob = 20;
  childCount: number = 0;
  loading: boolean = false;



  ngOnInit() {
    this.selectedRegime = 'general';
  }
 
  selectRegime(regime: string) {
    this.selectedRegime = regime;
  }
 
  onToggleButtonChange() {
    if (this.css) {
      this.visible = true;
    } else {
      this.visible = false;
    }
  }
 
  incrementChildCount() {
    if (this.childCount < 4) {
      this.childCount++;
    }
  }

  get enfants(): number[] {
    return Array(this.childCount).fill(0).map((x, i) => i);
  }

  decrementChildCount(index: number) {
    if (this.childCount > 0) {
      this.childCount--;
      this.enfants.splice(index, 1); 
    }
  }
  load() {
    this.loading = true;

    setTimeout(() => {
        this.loading = false
    }, 2000);
}

}
