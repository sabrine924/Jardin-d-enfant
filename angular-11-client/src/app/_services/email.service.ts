import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Email } from '../email/email';

//const baseUrl = "http://localhost:8081/sendingemail";
/*const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};*/
@Injectable({
  providedIn: 'root'
})
export class EmailService {
  //private baseUrl = "http://localhost:8081/sendingemail";
  constructor(private httpClient: HttpClient) { }

  email(to: string, subject: string, message: string) {
    return this.httpClient.post("http://localhost:8081/sendingemail", { to: to, subject: subject, message: message });
  }
}
