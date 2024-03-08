import {Devis} from "./Devis";

export class ContratResiliation {
  idCompteRes!: number;
  nom!: string;
  prenom!: string;
  numContrat!: string;
  organisme!: string;
  etat!: boolean;
  devis!: Devis;
}
