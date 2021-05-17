import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Conversation } from '../conversation';

@Injectable({
  providedIn: 'root'
})
export class ConversationService {

  //private baseUrl = "http://localhost:8081/conversations";

  constructor(private httpClient: HttpClient) { }

  createConversation(formdata: FormData) {
    return this.httpClient.post("http://localhost:8081/conversations", formdata);
  }

  getConversationsList(): Observable<Conversation[]> {
    return this.httpClient.get<Conversation[]>("http://localhost:8081/conversations");
  }
  deleteConversation(id: number): Observable<Object> {
    return this.httpClient.delete("http://localhost:8081/conversations/"+id);
  }

  
}
