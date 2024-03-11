import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from "@angular/router";
import { InformationsComponent } from "./Devis/informations/informations.component";
import {ProfilComponent} from "./Devis/profil/profil.component";


const routes: Routes = [
  { path: 'info', component: InformationsComponent },
  {path:'profil', component:ProfilComponent},

];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
