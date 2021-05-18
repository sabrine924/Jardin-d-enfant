import { Component, OnInit } from '@angular/core';
import {Post} from "../models/post";
import {ActivatedRoute} from "@angular/router";
import {PostService} from "../post.service";
import {CommentPostService} from "../comment-post.service";

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrls: ['./post-detail.component.css']
})
export class PostDetailComponent implements OnInit {
  id: number | undefined;
  post: Post | undefined;

  constructor(private http: ActivatedRoute, private postService: PostService, private commentPostService: CommentPostService) { }

  ngOnInit(): void {
    this.id = this.http.snapshot.params.id;
    this.post = new Post();
    this.postService.getPostById(this.id).subscribe( data => {
      this.post = data;
    });
  }

}
