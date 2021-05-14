import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './User';
import { Profile } from './Profile';


@Injectable({
  providedIn: 'root'
})
export class ProfileService {

  private baseURL = "http://localhost:8081";

  constructor(private httpClient: HttpClient) { }
  
  getProfilesList(): Observable<Profile[]>{
    return this.httpClient.get<Profile[]>(`${this.baseURL}/retrieve-all-profiles`);
  }

  createProfile(Profile: Profile): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/add-profile`, Profile);
  }

  getProfileById(id: number): Observable<Profile>{
    return this.httpClient.get<Profile>(`${this.baseURL}/retrieve-profile/${id}`);
  }

  /*updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/modify-user/${id}`, employee);
  }*/
  updateProfile(Profile: Profile): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/modify-profile`, Profile);
  }
  deleteProfile(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/remove-profile/${id}`);
  }
}
