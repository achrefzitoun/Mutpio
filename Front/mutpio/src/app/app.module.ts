import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { InformationsComponent } from './Adhesion/informations/informations.component';
import {DatePipe, HashLocationStrategy, LocationStrategy} from "@angular/common";
import { StepsModule } from 'primeng/steps';
import { ToastModule } from 'primeng/toast';
import { TriStateCheckboxModule } from 'primeng/tristatecheckbox';
import { CheckboxModule } from 'primeng/checkbox';
import { SplitterModule } from 'primeng/splitter';
import { FileUploadModule } from 'primeng/fileupload';
import { ProfilComponent } from './Devis/profil/profil.component';
import { RadioButtonModule } from 'primeng/radiobutton';
import {CommonModule} from "@angular/common";
import {FormsModule} from "@angular/forms";
import {AutoCompleteModule} from "primeng/autocomplete";
import {CalendarModule} from "primeng/calendar";
import {ChipsModule} from "primeng/chips";
import {DropdownModule} from "primeng/dropdown";
import {InputMaskModule} from "primeng/inputmask";
import {InputNumberModule} from "primeng/inputnumber";
import {CascadeSelectModule} from "primeng/cascadeselect";
import {MultiSelectModule} from "primeng/multiselect";
import {InputTextareaModule} from "primeng/inputtextarea";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {ToggleButtonModule} from "primeng/togglebutton";
import {SelectButtonModule} from "primeng/selectbutton";
import { InputTextModule } from 'primeng/inputtext';
import { FieldsetModule } from 'primeng/fieldset';
import { CardModule } from 'primeng/card';
import { AvatarModule } from 'primeng/avatar';
import { MondatdetailsComponent } from './Adhesion/mondatdetails/mondatdetails.component';
import { KeyFilterModule } from 'primeng/keyfilter';
import { PaiementComponent } from './Adhesion/paiement/paiement.component';
import { InputSwitchModule } from 'primeng/inputswitch';
import { BlockUIModule } from 'primeng/blockui';
import { PanelModule } from 'primeng/panel';
import { TableModule } from 'primeng/table';
import { SignatureComponent } from './Adhesion/signature/signature.component';

@NgModule({
  declarations: [
    AppComponent,
    InformationsComponent,
    ProfilComponent,  
    MondatdetailsComponent, PaiementComponent, SignatureComponent  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    InputTextModule,
    BlockUIModule,
    PanelModule,
    CheckboxModule ,
    RadioButtonModule,
    CommonModule,
    FormsModule,
    AutoCompleteModule,
    CalendarModule,
    ChipsModule,
    InputSwitchModule,
    DropdownModule,
    InputMaskModule,
    InputNumberModule,
    CascadeSelectModule,
    MultiSelectModule,
    InputTextareaModule,KeyFilterModule,
    InputTextModule,
    StepsModule,
    ToastModule,
    TriStateCheckboxModule,
    ToggleButtonModule,
    CheckboxModule,
    SplitterModule,
    FileUploadModule,
    ToggleButtonModule,
    SelectButtonModule,
    FieldsetModule,
    CardModule,
    AvatarModule,
    TableModule
  ],
  providers: [
  { provide: LocationStrategy, useClass: HashLocationStrategy },DatePipe
],
  bootstrap: [AppComponent]
})
export class AppModule { }
