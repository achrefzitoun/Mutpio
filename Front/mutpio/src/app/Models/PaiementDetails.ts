import {Devis} from "./Devis";

export class PaiementDetails {
  mac!: string;
  datePaiement!: Date;
  tpe!: string;
  montant!: number;
  currency!: string;
  reference!: string;
  texteLibre!: string;
  codeRetour!: string;
  cvx!: string;
  vld!: string;
  brand!: string;
  status3ds!: string;
  numauto!: string;
  motifrefus!: string;
  originecb!: string;
  veres!: string;
  pares!: string;
  montantech!: string;
  filtragecause!: string;
  filtragevaleur!: string;
  cbenregistree!: string;
  cbmasquee!: string;
  modepaiement!: string;
  authentification!: string;
  devis!: Devis;
}
