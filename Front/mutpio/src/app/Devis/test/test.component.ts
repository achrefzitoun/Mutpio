import { Component, OnInit } from '@angular/core';
import { AdressePostale } from 'src/app/Models/AdressePostale';
import { Compte } from 'src/app/Models/Compte';
import { Contact } from 'src/app/Models/Contact';
import { ContratResiliation } from 'src/app/Models/ContratResiliation';
import { Devis } from 'src/app/Models/Devis';
import { Etat } from 'src/app/Models/Etat';
import { Formule } from 'src/app/Models/Formule';
import { PaiementDetails } from 'src/app/Models/PaiementDetails';
import { Prospect } from 'src/app/Models/Prospect';
import { Regime } from 'src/app/Models/Regime';
import { Signature } from 'src/app/Models/Signature';
import { ProfilService } from 'src/app/Services/profil.service';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {


  constructor(private serv: ProfilService) { }


  Prosp: Prospect = {
    idProspect: 0,
    nom: "",
    prenom: "",
    dateNaissance: '',
    regime: Regime.GENERALE,
    PPE: true,
    devis: [],
    compte: new Compte(),
    contact: new Contact(),
    adressePostale: new AdressePostale
  }

  contact: Contact = {
    idContact: 0,
    email: "",
    numTel: "",
    prospect: new Prospect
  }

  devis: Devis = {
    idDevis: 0,
    numDevis: "",
    besoinSpecifique: "",
    dateAdhesion: "",
    dateDevis: new Date(),
    dateExpiration: new Date(),
    valDevis: 0,
    retraite: false,
    etat: Etat.EN_COURS_DE_TRAITEMENT,
    beneficiares: [],
    signature: new Signature,
    refBancaire: [],
    prospect: this.Prosp,
    contratResiliation: new ContratResiliation,
    formule: new Formule,
    paiementDetails: new PaiementDetails
  };

  naissance!: Date
  adhesion!:Date

  selectedRegimeProspect: string = 'GENERALE';

  ppe!: boolean;


  ngOnInit() {

  }
  
  selectRegimeProspect(regime: string) {
    this.selectedRegimeProspect = regime;
    console.log(this.selectedRegimeProspect);

  }

  convertirEnRegime(regimeString: string): Regime {
    switch (regimeString) {
      case 'GENERALE':
        return Regime.GENERALE;
      case 'TNS':
        return Regime.TNS;
      case 'ALSACE_MOSELLE':
        return Regime.ALSACE_MOSELLE;
      default:
        throw new Error(`Regime non reconnu: ${regimeString}`);
    }
  }


  convertDate(inputDate: Date): string {
    const date = new Date(inputDate);

    const year = date.getFullYear();
    const month = ('0' + (date.getMonth() + 1)).slice(-2);
    const day = ('0' + date.getDate()).slice(-2);

    const formattedDate = `${year}-${month}-${day}`;

    return formattedDate;
  }

  togglePPE(event: any) {
      this.ppe = event.checked
      console.log(event.checked)
      this.Prosp.PPE = this.ppe   
    
  }

  addProsp() {
    
    const dateconv = this.convertDate(this.naissance);
    this.Prosp.dateNaissance = dateconv;

    this.Prosp.regime = this.convertirEnRegime(this.selectedRegimeProspect);
    this.Prosp.contact= this.contact
    
    console.log(this.Prosp.PPE)
    this.serv.addProsp(this.Prosp, dateconv).subscribe();
  }


  
  onSubmit() {
    
    const dateconv = this.convertDate(this.naissance);
    this.Prosp.dateNaissance = dateconv;

    this.Prosp.regime = this.convertirEnRegime(this.selectedRegimeProspect);
    this.Prosp.contact= this.contact
    
    console.log(this.Prosp.PPE)
    this.serv.addProsp(this.Prosp, dateconv).subscribe(
        prospect => {
    console.log('Prospect ajouté avec succès:', prospect);

    // Associer le prospect sauvegardé au devis
    this.devis.prospect = prospect;

    const dateAdh = this.convertDate(this.adhesion);
    this.devis.dateAdhesion = dateAdh;

    // Ajouter le devis
    this.serv.addDevis(this.devis, dateAdh).subscribe(
      response => {
        console.log('Devis ajouté avec succès:', response);
      },
      error => {
        console.error('Erreur lors de l\'ajout du devis:', error);
      }
    );
  },
  error => {
    console.error('Erreur lors de l\'ajout du prospect:', error);
  }
    );
  }

}
