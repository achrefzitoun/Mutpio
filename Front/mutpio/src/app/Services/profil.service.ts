import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Devis } from '../Models/Devis';

@Injectable({
  providedIn: 'root'
})
export class ProfilService {

  constructor(private http: HttpClient) { }
  private apiUrl = 'http://localhost:8080/mutpio/profil';
  
  addProfil(devis:Devis){
     this.http.post(`${this.apiUrl}/add`, devis);
  }

}
