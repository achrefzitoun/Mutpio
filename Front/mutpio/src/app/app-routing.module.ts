import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from "@angular/router";
import { InformationsComponent } from "./Devis/informations/informations.component";
import {ProfilComponent} from "./Devis/profil/profil.component";
import { BesoinsComponent } from './Devis/besoins/besoins.component';
import { TestComponent } from './Devis/test/test.component';


const routes: Routes = [
  { path: 'info', component: InformationsComponent },
  {path:'profil', component:ProfilComponent},
  {path:'besoins', component:BesoinsComponent},
  {path:'test', component:TestComponent}


];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
