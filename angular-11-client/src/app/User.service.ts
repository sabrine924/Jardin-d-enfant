import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { User } from './User';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL = "http://localhost:8081";

  constructor(private httpClient: HttpClient) { }
  
  getUsersList(): Observable<User[]>{
    return this.httpClient.get<User[]>(`${this.baseURL}/retrieve-all-users`);
  }

  createUser(User: User): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}/api/auth/signup`, User);
  }

  getUserById(id: number): Observable<User>{
    return this.httpClient.get<User>(`${this.baseURL}/retrieve-user/${id}`);
  }

  /*updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/modify-user/${id}`, employee);
  }*/
  updateUser(User: User): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/modify-user`, User);
  }
  deleteUser(id: number): Observable<Object>{
    return this.httpClient.delete(`${this.baseURL}/remove-user/${id}`);
  }
}
