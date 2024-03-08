import {Regime} from "./Regime";

export class Tarificateur {
  id!: number;
  idForume!: number;
  codeTarification!: string;
  typeTarification!: string;
  regime!: Regime;
  surComplementaire!: boolean;
  statusRetraite!: boolean;
  ageLimiteAdhesion!: number;
  nbrAdult!: number;
  nbrEnfant!: number;
  ageDe!: number;
  ageA!: number;
  cotisation!: number;

}
