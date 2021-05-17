import { Component, OnInit } from '@angular/core';
import {CommentPost} from "../models/CommentPost";
import {CommentPostService} from "../comment-post.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-update-comment',
  templateUrl: './update-comment.component.html',
  styleUrls: ['./update-comment.component.css']
})
export class UpdateCommentComponent implements OnInit {
  id: number;
  commentPost: CommentPost = new CommentPost();

  constructor(private commentPostService: CommentPostService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params.id;

    this.commentPostService.getCommentPostById(this.id).subscribe(data => {
      this.commentPost = data;
    }, error => console.log(error));
  }
  onSubmit(){
    this.commentPostService.updateComment(this.commentPost, this.id).subscribe( data => {
        this.goToEmployeeList();
      }
      , error => console.log(error));
  }

  goToEmployeeList(){
    this.router.navigate(['comments']);
  }

}
