import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Message } from '../message';
//import { Message } from '../send-message/message';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private baseUrl = "http://localhost:8081/messages";

  constructor(private httpClient: HttpClient) { }
  
  getMessagesList(convId: number): Observable<Message[]> {
    var conv = convId.toString();
    const headerDict = {
      'Content-Type': 'application/json',
      'Accept': 'application/json',
      'Access-Control-Allow-Origin': '*',
    }
    const requestOptions = {                                                                                                                                                                                 
      headers: new HttpHeaders(headerDict), 
    };
    return this.httpClient.get<Message[]>("http://localhost:8081/messages/"+conv,requestOptions);
  }
  createMessage(message: Message): Observable<Object>{
    return this.httpClient.post("http://localhost:8081/add-message", message);
  }
}
