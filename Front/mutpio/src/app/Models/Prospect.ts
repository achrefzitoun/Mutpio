import {Devis} from "./Devis";
import {Compte} from "./Compte";
import {Contact} from "./Contact";
import {AdressePostale} from "./AdressePostale";
import {Regime} from "./Regime";

export class Prospect {
  idProspect!: number;
  nom!: string;
  prenom!: string;
  dateNaissance!: Date;
  regime!: Regime;
  PPE!: boolean;
  devis!: Devis[];
  compte!: Compte;
  contact!: Contact;
  adressePostale!: AdressePostale;
}
