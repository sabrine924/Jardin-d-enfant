import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Post} from "./models/post";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private baseUrl = 'http://localhost:8081/api/v1/retrieve-all-posts';
  private baseUrll = 'http://localhost:8081/api/v1/addPostSimple';
  private baseUrlll = 'http://localhost:8081/api/v1/retrieve-post';
  private baseUrllll = 'http://localhost:8081/api/v1/remove-post';
  private baseUrlllll = 'http://localhost:8081/api/v1/add-post';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }
  getPostsList(): Observable<Post[]> {
    return this.http.get<Post[]>(`${this.baseUrl}`);
  }

  /*create(data: any): Observable<any> {
    return this.http.post(this.baseUrll, data);
  }*/
  create(post, id): Observable<any> {
    return this.http.put<Post>(`${this.baseUrlllll}/${id}`, JSON.stringify(post), this.httpOptions);
  }

  getPostById(id: number | undefined): Observable<Post>{
    return this.http.get<Post>(`${this.baseUrlll}/${id}`);
  }
  deletePost(id): Observable<Post>{
    return this.http.delete<Post>(`${this.baseUrllll}/${id}`);
  }
}
