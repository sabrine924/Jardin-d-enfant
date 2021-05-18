import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http'
import {  Observable } from 'rxjs';
import {Event} from '../models/event'
import { map } from 'rxjs/operators';
import { Category } from '../models/category';
@Injectable({
  providedIn: 'root'
})
export class EventService {
  baseUrl = "http://localhost:8081/api/v1/events";
  constructor(private http: HttpClient) {
  }


getEvent(idEvent: number): Observable<any> {
  var baseUrl = "http://localhost:8081/api/v1/events/retrieveevents/"
  return this.http.get(baseUrl  +idEvent);
}

getEventsList(): Observable<any[]>{
  return this.http.get<Event[]>("http://localhost:8081/api/v1/events/retrieveallevents");
}

createEvent(event: Object): Observable<Object>{
  return this.http.post("http://localhost:8081/api/v1/events/addevent/",event); 
}

deleteEvent(idEvent: number): Observable<Object>{
  return this.http.delete("http://localhost:8081/api/v1/events/delete-event/"+idEvent);
}

updateEvent( idEvent: number , value: any): Observable<Object> {
return this.http.post("http://localhost:8081/api/v1/up-event/"+idEvent, value);
}

exportPDFEvent(): Observable<Blob>{
  return this.http.get("http://localhost:8081/api/v1/events/export/pdf/",  { responseType: 'blob'});
}

getEventByName(name: string): Observable<Event[]>{
    return this.http.get<Event[]>("http://localhost:8081/api/v1/events/retrieve-Event-ByName/" + name);
  }

  getEventByLocation(location: string ){
    return this.http.get<Event[]>("http://localhost:8081/api/v1/events/retrieve-Event-ByLocation/" + location);

  }
  getEventByCategory(category: string){
    return this.http.get<Event[]>("http://localhost:8081/api/v1/events/retrieve-Event-ByCategory/" + category);

  }
 getEventbetween2dates(date1: Date, date2: Date): Observable<Event[]>{
    return this.http.get<Event[]>("http://localhost:8081/api/v1/events/getEventsBetweenTwoDates/" + date1 + '/'+ date2);

  }
  getNbrParticipants(): Observable<Object>{
    return  this.http.get<Event[]>("http://localhost:8081/api/v1/participants/maxcagnotte")
  }
  getStatEvent(): Observable<Category[]>
  {
    return  this.http.get<Category[]>("http://localhost:8081/api/v1/events/statistiques")
  } 
  updateEvent1( value: any): Observable<Object> {
    return this.http.put("http://localhost:8081/api/v1/events/update-event", value);
    }
}