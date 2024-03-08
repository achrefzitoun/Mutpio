import {EtatCompte} from "./EtatCompte";
import {Prospect} from "./Prospect";

export class Compte {
  idCompte!: number;
  email!: string;
  password!: string;
  dateCreation!: Date;
  etatCompte!: EtatCompte;
  prospect!: Prospect;
}
