import {Devis} from "./Devis";
import {TypeRef} from "./TypeRef";

export class RefBancaire {
  idRefBancaire!: number;
  frequence!: string;
  iban!: string;
  bic!: string;
  titulaire!: string;
  typeRef!: TypeRef;
  jourPrelevement!: number;
  devis!: Devis;
}
