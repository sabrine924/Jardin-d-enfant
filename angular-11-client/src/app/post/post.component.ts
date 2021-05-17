import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Post} from "../models/post";
import {Router} from "@angular/router";
import {PostService} from "../post.service";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  @Input() post: Post | undefined;
  @Output() incrementEvent = new EventEmitter<Post>();
  @Output() incrementEventt = new EventEmitter<Post>();
  @Output() incrementEventtt = new EventEmitter<Post>();

  constructor(private postService: PostService,
              private router: Router) { }

  ngOnInit(): void {
  }
  sendLike(){
    this.incrementEvent.emit(this.post);
  }
  sendDislike(){
    this.incrementEventt.emit(this.post);
  }
  postDetails(id: number){
    this.router.navigate(['post-details', id]);
  }
  senddeletePost(){
    this.incrementEventtt.emit(this.post);
  }

}
