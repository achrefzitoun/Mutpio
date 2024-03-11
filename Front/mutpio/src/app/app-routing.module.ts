import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {ProfilComponent} from "./Devis/profil/profil.component";

const routes: Routes = [
  {path:'profil', component:ProfilComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
