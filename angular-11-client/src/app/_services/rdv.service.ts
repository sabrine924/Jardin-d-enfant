import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Rdv } from '../rdv';
//import { Rdv } from '../rdv/rdv';

@Injectable({
  providedIn: 'root'
})
export class RdvService {

  private baseUrl = "http://localhost:8081/rdvs";

  constructor(private httpClient: HttpClient) { }

  getRdvsList(): Observable<Rdv[]>{
    return this.httpClient.get<Rdv[]>("http://localhost:8081/rdvs");
  }

  createRdv(formdata: FormData): Observable<Object>{
    return this.httpClient.post("http://localhost:8081/rdvs", formdata);
  }

  updateRdv(formdata: FormData){
    return this.httpClient.put("http://localhost:8081/rdvs/", formdata);
  }

  deleteRdv(idRdv: number): Observable<Object>{
    return this.httpClient.delete("http://localhost:8081/rdvs/"+idRdv);
  }

  getRdvById(idRdv: number){
    return this.httpClient.get<Rdv>("http://localhost:8081/rdv/"+idRdv);
  }
}


