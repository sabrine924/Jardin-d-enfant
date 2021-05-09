import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../User';
import { UserListComponent } from '../user-list/user-list.component';
import { UserService } from '../User.service';
import {Location} from '@angular/common';
import { TokenStorageService } from '../_services/token-storage.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {

  id!: number;
  user!: User 
  currentUser: any;
  constructor(private token: TokenStorageService, private route: ActivatedRoute, private userService: UserService,
    private router: Router) { }
  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.id = this.route.snapshot.params['id'];

    this.user = new User();
    this.userService.getUserById(this.id).subscribe( data => {
      this.user = data;
    });
  }
  onSubmit(){
    this.router.navigate(['/retrieve-all-users']);
  }

}
