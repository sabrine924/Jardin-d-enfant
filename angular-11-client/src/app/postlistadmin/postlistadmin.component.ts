import { Component, OnInit } from '@angular/core';
import {Reaction} from "../models/Reaction";
import {Post} from "../models/post";
import {PostService} from "../post.service";
import {ReactionService} from "../reaction.service";
import {TokenStorageService} from "../_services/token-storage.service";

@Component({
  selector: 'app-postlistadmin',
  templateUrl: './postlistadmin.component.html',
  styleUrls: ['./postlistadmin.component.css']
})
export class PostlistadminComponent implements OnInit {
  currentUser: any;
  reaction: Reaction | undefined ;
  //reaction = new Reaction();
  listposts?: Post[];

  constructor(private postService: PostService, private reactionService: ReactionService, private token: TokenStorageService) { }


  ngOnInit(): void {
    this.retrievePosts();
    this.currentUser = this.token.getUser();
  }
  retrievePosts(): void {
    this.postService.getPostsList()
      .subscribe(
        data => {
          this.listposts = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  /*incrementLike(p: Post){
    this.reactionService.addLike(this.reaction, p.idPost, this.currentUser.id).subscribe( data => {
        console.log(data);
      },
      error => console.log(error));

  }*/
 /* incrementDislike(p: Post){
    this.reactionService.addDislike(this.reaction, p.idPost, this.currentUser.id).subscribe( data => {
        console.log(data);
      },
      error => console.log(error));

  }*/
/*  deletePost(p: Post){
    this.postService.deletePost(p.idPost).subscribe( data => {
      console.log(data);
    })
  }*/


}
