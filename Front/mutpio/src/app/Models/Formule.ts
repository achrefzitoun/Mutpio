import {Devis} from "./Devis";
import {RisqueLevel} from "./RisqueLevel";

export class Formule {
  id!: number;
  formuleLabel!: string | null;
  formulePrice!: number | null;
  dateDerniereModification!: Date | null;
  descFormule!: string | null;
  devis!: Devis[] | null;
  risqueLevels!: RisqueLevel[] | null;

}
