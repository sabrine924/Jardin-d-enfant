import { Component, OnInit } from '@angular/core';
import {CommentPost} from "../models/CommentPost";
import {ActivatedRoute, Router} from "@angular/router";
import {CommentPostService} from "../comment-post.service";
import {TokenStorageService} from "../_services/token-storage.service";

@Component({
  selector: 'app-comment-post',
  templateUrl: './comment-post.component.html',
  styleUrls: ['./comment-post.component.css']
})
export class CommentPostComponent implements OnInit {
  currentUser: any;
  listComment: CommentPost[] | undefined;
  commentPost: CommentPost = new CommentPost();
  id: number | undefined;
  idCom: number | undefined;

  constructor(private http: ActivatedRoute, private commentPostService: CommentPostService, private router: Router, private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.id = this.http.snapshot.params.id;
    this.commentPostService.getCommentbyId(this.id).subscribe(data => {
      this.listComment = data;
    });
  }
  updateComment(id: number){
    this.router.navigate(['update-comment', id]);
  }
  deleteComment(id: number){
    this.commentPostService.deleteComment(id).subscribe( data => {
      console.log(data);
    });
  }
  saveComment(){
    this.commentPostService.createCommentPost(this.commentPost, this.id, this.currentUser.id).subscribe( data => {
        console.log('comment created');
       // this.listComment = [this.commentPost, ...this.listComment];
      },
      error => console.log(error));
  }



  onSubmit(){
    console.log(this.commentPost);
    this.saveComment();
  }


}
