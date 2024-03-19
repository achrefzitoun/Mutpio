import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule, Routes } from "@angular/router";
import { InformationsComponent } from "./Adhesion/informations/informations.component";
import {ProfilComponent} from "./Devis/profil/profil.component";
import { MondatdetailsComponent } from './Adhesion/mondatdetails/mondatdetails.component';
import { PaiementComponent } from './Adhesion/paiement/paiement.component';
import { SignatureComponent } from './Adhesion/signature/signature.component';


const routes: Routes = [
  {path: 'info', component: InformationsComponent },
  {path: 'mondat', component: MondatdetailsComponent },
  {path: 'paiement', component: PaiementComponent },
  {path: 'signature', component: SignatureComponent  },

  {path:'profil', component:ProfilComponent},

];

@NgModule({
  declarations: [],
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
