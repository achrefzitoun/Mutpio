import {Regime} from "./Regime";
import {TypeBeneficiare} from "./TypeBeneficiare";
import {Devis} from "./Devis";

export class Beneficiare {
  idBeneficiare!: number;
  numBeneficiare!: string;
  nom!: string;
  prenom!: string;
  noSs!: string;
  cleSs!: string;
  situation!: string;
  nomJeuneFille!: string;
  dateNaissance!: Date;
  dateClotureComptable!: Date;
  frontalier!: boolean;
  parraine!: boolean;
  femme!: boolean;
  regime!: Regime;
  typeBeneficiare!: TypeBeneficiare;
  document!: Document[];
  devis!: Devis;

}
