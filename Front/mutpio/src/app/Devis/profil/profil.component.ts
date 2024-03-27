import { Component, OnInit } from '@angular/core';
import { AdressePostale } from 'src/app/Models/AdressePostale';
import { Beneficiare } from 'src/app/Models/Beneficiare';
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
import { TypeBeneficiare } from 'src/app/Models/TypeBeneficiare';
import { ProfilService } from 'src/app/Services/profil.service';


@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  constructor(private serv: ProfilService) { }


  valRadio: string = '';

  css: boolean = false;
  visible = false;
  ppe: boolean = false;
  conjoint: boolean = false;
  childCount: number = 0;
  loading: boolean = false;


  Prosp: Prospect = {
    idProspect: 0,
    nom: "",
    prenom: "",
    dateNaissance: " ",
    regime: Regime.GENERALE,
    PPE: false,
    devis: [],
    compte: new Compte(),
    contact: new Contact(),
    adressePostale: new AdressePostale()
  }


  contact: Contact = {
    idContact: 0,
    email: "",
    numTel: "",
    prospect: new Prospect
  }

  contrat!: ContratResiliation

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

  selectedRegimeProspect: string = 'GENERALE';
  selectedRegimeConjoint: string = 'GENERALE';

  enfantsRegimes: string[] = [];


  conjointBen: Beneficiare = {
    idBeneficiare: 0,
    numBeneficiare: "",
    nom: "",
    prenom: "",
    noSs: "",
    cleSs: "",
    situation: "",
    nomJeuneFille: "",
    dateNaissance: new Date(),
    dateClotureComptable: new Date(),
    frontalier: false,
    parraine: false,
    femme: false,
    regime: Regime.GENERALE,
    typeBeneficiare: TypeBeneficiare.CONJOINT,
    document: [],
    devis: new Devis
  };

  Enfants: Beneficiare[] = [];
  datesNaissanceEnfants: Date[] = [];

  souscripteur!: Beneficiare;

  ngOnInit() {

  }

  selectRegimeProspect(regime: string) {
    this.selectedRegimeProspect = regime;
    console.log(this.selectedRegimeProspect);

  }

  selectRegimeConjoint(regime: string) {
    this.selectedRegimeConjoint = regime;
    console.log(this.selectedRegimeConjoint);
  }

  selectRegimeEnfant(index: number, regime: string) {
    this.enfantsRegimes[index] = regime;
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


  addConjoint() {
    if (this.conjoint) {

      this.conjointBen = new Beneficiare();
      this.conjointBen.typeBeneficiare = TypeBeneficiare.CONJOINT;
      this.conjointBen.regime = this.convertirEnRegime(this.selectedRegimeConjoint);

      console.log('Conjoint(e) a été ajouté !');
    }

  }

  addEnfant() {
    const nouvelEnfant: Beneficiare = new Beneficiare();
    nouvelEnfant.typeBeneficiare = TypeBeneficiare.ENFANT;
    nouvelEnfant.regime = this.convertirEnRegime(this.enfantsRegimes[this.enfants.length]);
    nouvelEnfant.dateNaissance = this.datesNaissanceEnfants[this.enfants.length];
    this.Enfants.push(nouvelEnfant);
    this.datesNaissanceEnfants.push(new Date());

    console.log('Un nouvel enfant a été ajouté !');

  }


  save() {

    this.devis.prospect = this.Prosp;
    /*this.Prosp.regime = this.convertirEnRegime(this.selectedRegimeProspect);

    this.souscripteur = new Beneficiare();
    this.souscripteur.typeBeneficiare = TypeBeneficiare.SOUSCRIPTEUR;
    this.souscripteur.regime = this.convertirEnRegime(this.selectedRegimeProspect);
    this.souscripteur.dateNaissance = this.Prosp.dateNaissance;
    this.devis.beneficiares.push(this.souscripteur);

    if (this.conjoint) {
      this.devis.beneficiares.push(this.conjointBen);
    }

    if (this.valRadio === 'choix1') {
      this.devis.contratResiliation = this.contrat;
    }

    if (this.enfants.length > 0) {
      for (let enfant of this.Enfants) {
        this.devis.beneficiares.push(enfant);
      }
    }*/
    this.serv.addProfil(this.devis).subscribe(() => {
      console.log('Devis ajouté avec succès');
      // Réinitialiser le formulaire ou effectuer toute autre action nécessaire après l'ajout du devis
    },
      error => {
        console.error('Erreur lors de l\'ajout du devis:', error);
        // Gérer l'erreur, afficher un message d'erreur à l'utilisateur, etc.
      }
    );

  }


  onDateNaissanceChange(selectedDate: Date) {
    // Obtenir l'année, le mois et le jour de la date sélectionnée
    const year = selectedDate.getFullYear();
    const month = (selectedDate.getMonth() + 1).toString().padStart(2, '0'); // Les mois commencent à 0, donc on ajoute 1
    const day = selectedDate.getDate().toString().padStart(2, '0');

    // Formater la date au format "yyyy-MM-dd"
    const dateFormatee = `${year}-${month}-${day}`;
    // Afficher la date formatée dans la console
    console.log(dateFormatee);

    //this.Prosp.dateNaissance = dateFormatee;
  
  }


  onSubmit() {
    console.log(this.Prosp.nom);
    console.log(this.Prosp.prenom);
    console.log(this.Prosp.dateNaissance);
    console.log(this.devis.dateAdhesion);
    console.log(this.Prosp.contact.email)


    /*this.Prosp.regime = this.convertirEnRegime(this.selectedRegimeProspect);
    console.log(this.Prosp.regime);

    // Sauvegarder le prospect avant de l'associer au devis
    this.serv.addProsp(this.Prosp).subscribe(
      prospect => {
        console.log('Prospect ajouté avec succès:', prospect);

        // Associer le prospect sauvegardé au devis
        this.devis.prospect = prospect;

        // Sauvegarder le devis avec le prospect associé
        this.serv.addDevis(this.devis).subscribe(
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
    );*/
  }

  

  

  

}