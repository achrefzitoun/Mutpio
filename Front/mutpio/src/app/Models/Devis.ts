import {ContratResiliation} from "./ContratResiliation";
import {Etat} from "./Etat";
import {Beneficiare} from "./Beneficiare";
import {Signature} from "./Signature";
import {RefBancaire} from "./RefBancaire";
import {Prospect} from "./Prospect";
import {Formule} from "./Formule";
import {PaiementDetails} from "./PaiementDetails";

export class Devis {
  idDevis!: number;
  numDevis!: string;
  besoinSpecifique!: string;
  dateAdhesion!: Date;
  dateDevis!: Date;
  dateExpiration!: Date;
  valDevis!: number;
  retraite!: boolean;
  etat!: Etat;
  beneficiares!: Beneficiare[];
  signature!: Signature;
  refBancaire!: RefBancaire[];
  prospect!: Prospect;
  contratResiliation!: ContratResiliation;
  formule!: Formule;
  paiementDetails!: PaiementDetails;

}
