import { Component, OnInit } from '@angular/core';
import {Post} from "../models/post";
import {PostService} from "../post.service";
import {FileUploadService} from "../file-upload.service";
import {TokenStorageService} from "../_services/token-storage.service";

@Component({
  selector: 'app-addpost',
  templateUrl: './addpost.component.html',
  styleUrls: ['./addpost.component.css']
})
export class AddpostComponent implements OnInit {
  currentUser: any;
  post: Post = new Post();
  // Variable to store shortLink from api response
  //shortLink: string = "";
  loading = false; // Flag variable
  file: null = null; // Variable to store file

  constructor(private postService: PostService, private fileUploadService: FileUploadService, private token: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
  }
  // On file Select
  onChange(event: { target: { files: null[]; }; }) {
    this.file = event.target.files[0];
  }

  // OnClick of button Upload
  onUpload() {
    this.loading = !this.loading;
    console.log(this.file);
   // this.fileUploadService.upload(this.file).subscribe(
      (event: any) => {
        if (typeof (event) === 'object') {

          // Short link via api response
          this.post.subjectPost = event.link;

          this.loading = false; // Flag variable
        }
      }
   // );
  }
  savePost(){
   /* this.postService.create(this.post, this.currentUser.id).subscribe( data => {
        console.log(data);
      },
      error => console.log(error));
  }*/



 /* onSubmit(){
    console.log(this.post);
    this.savePost();
  }*/


}
}