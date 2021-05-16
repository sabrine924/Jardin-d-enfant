import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {CommentPost} from "./models/CommentPost";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CommentPostService {
  private baseUrl = 'http://localhost:8081/api/v1';
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }
  createComment(commentPost, idPost): Observable<CommentPost> {
    return this.http.put<CommentPost>(this.baseUrl + '/add-commentPostSimple/' + idPost, JSON.stringify(commentPost), this.httpOptions);
  }
  getCommentbyId(idPost): Observable<CommentPost[]> {
    return this.http.get<CommentPost[]>(this.baseUrl + '/getAllCommentByPost/' + idPost);
    // return this.http.get(`${this.baseUrl}`);
  }
  deleteComment(commentPostId): Observable<CommentPost>{
    return this.http.delete<CommentPost>(this.baseUrl + '/remove-commentPost/' + commentPostId);
  }
  updateComment(commentPost, commentPostId): Observable<Comment> {
    return this.http.put<Comment>(this.baseUrl + '/modify-commentPost/' + commentPostId, commentPost);
  }
  getCommentPostById(idCommentPost): Observable<CommentPost> {
    return this.http.get<CommentPost>(this.baseUrl + '/retrieve-commentPost/' + idCommentPost);
    // return this.http.get(`${this.baseUrl}`);
  }

}
