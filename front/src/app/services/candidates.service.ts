import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Candidates } from '../models/candidates.mode';

@Injectable({
  providedIn: 'root'
})
export class CandidatesService {

  apiUrl: string = "http://localhost:8080/jakarta-1.0-SNAPSHOT/api/candidates"; 

  constructor(private http: HttpClient) { }

  getUsuarioData(cedula: string): Observable<any> {
    return this.http.get(`${this.apiUrl}/${cedula}`); // Realiza una solicitud GET a la API
  }

  // Crear un nuevo usuario
  createCandidate(candidate: Candidates): Observable<string> {
    return this.http.post<string>(this.apiUrl, candidate);
  }
}
