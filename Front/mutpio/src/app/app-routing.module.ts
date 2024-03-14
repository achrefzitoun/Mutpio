import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from "@angular/router";
import { InformationsComponent } from "./Devis/informations/informations.component";
import {ProfilComponent} from "./Devis/profil/profil.component";
import { BesoinsComponent } from './Devis/besoins/besoins.component';


const routes: Routes = [
  { path: 'info', component: InformationsComponent },
  {path:'profil', component:ProfilComponent},
  {path:'besoins', component:BesoinsComponent}

];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
