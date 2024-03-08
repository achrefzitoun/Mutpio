import {Beneficiare} from "./Beneficiare";

export class Document {
  idDocument!: number;
  numDocument!: string;
  labelDocument!: string;
  typeDocument!: string;
  document!: Uint8Array;
  beneficiare!: Beneficiare;
}
