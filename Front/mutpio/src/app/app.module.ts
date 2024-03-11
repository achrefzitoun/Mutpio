import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { InformationsComponent } from './Devis/informations/informations.component';
import {RouterOutlet} from "@angular/router";

import {HashLocationStrategy, LocationStrategy} from "@angular/common";
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

@NgModule({
  declarations: [
    AppComponent,
    InformationsComponent,
    ProfilComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserModule,
    BrowserAnimationsModule,
    InputTextModule,
    CheckboxModule ,
    RadioButtonModule,
    CommonModule,
    FormsModule,
    AutoCompleteModule,
    CalendarModule,
    ChipsModule,
    DropdownModule,
    InputMaskModule,
    InputNumberModule,
    CascadeSelectModule,
    MultiSelectModule,
    InputTextareaModule,
    InputTextModule,
    StepsModule,
    ToastModule,
    TriStateCheckboxModule,
    ToggleButtonModule,
    CheckboxModule,
    SplitterModule,
    FileUploadModule,
    ToggleButtonModule,
    SelectButtonModule
  ],
  providers: [
  { provide: LocationStrategy, useClass: HashLocationStrategy },
],
  bootstrap: [AppComponent]
})
export class AppModule { }
