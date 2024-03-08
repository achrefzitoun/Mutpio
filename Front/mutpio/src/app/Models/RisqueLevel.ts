import {Risque} from "./Risque";

export class RisqueLevel {
  id!: number;
  levelLabel!: string;
  levelPrice!: string;
  DerniereModification!: Date;
  risque!: Risque;
}
