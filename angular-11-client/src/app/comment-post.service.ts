import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {CommentPost} from "./models/CommentPost";
import {Observable} from "rxjs";
import {Reaction} from "./models/Reaction";

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
  createComment(commentPost: any, idPost: string): Observable<CommentPost> {
    return this.http.put<CommentPost>(this.baseUrl + '/add-commentPostSimple/' + idPost, JSON.stringify(commentPost), this.httpOptions);
  }
  createCommentPost(commentPost: CommentPost, idPost: string | number | undefined, idUser: string): Observable<CommentPost> {
    return this.http.put<CommentPost>(this.baseUrl + '/add-commentPost/' + idPost + '/' + idUser, JSON.stringify(commentPost), this.httpOptions);
  }
  getCommentbyId(idPost: string | number | undefined): Observable<CommentPost[]> {
    return this.http.get<CommentPost[]>(this.baseUrl + '/getAllCommentByPost/' + idPost);
    // return this.http.get(`${this.baseUrl}`);
  }
  deleteComment(commentPostId: string | number): Observable<CommentPost>{
    return this.http.delete<CommentPost>(this.baseUrl + '/remove-commentPost/' + commentPostId);
  }
  updateComment(commentPost: CommentPost, commentPostId: string | number): Observable<Comment> {
    return this.http.put<Comment>(this.baseUrl + '/modify-commentPost/' + commentPostId, commentPost);
  }
  getCommentPostById(idCommentPost: string | number): Observable<CommentPost> {
    return this.http.get<CommentPost>(this.baseUrl + '/retrieve-commentPost/' + idCommentPost);
    // return this.http.get(`${this.baseUrl}`);
  }

}
