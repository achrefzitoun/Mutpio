import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Devis } from '../Models/Devis';
import { Observable } from 'rxjs';
import { Prospect } from '../Models/Prospect';
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class ProfilService {

  constructor(private http: HttpClient) { }

  addProfil(devis: Devis): Observable<any> {
    return this.http.post("http://localhost:8080/mutpio/profil/add", devis);
  }

  addDevis(devis: Devis, adhesion : string): Observable<any> {
    return this.http.post('http://localhost:8080/mutpio/profil/devis?naissance=' + adhesion, devis);
  }


  addProsp(prospect: Prospect, naissance: string): Observable<any> {
    return this.http.post('http://localhost:8080/mutpio/profil/prosp?naissance=' + naissance, prospect);
  }






}
