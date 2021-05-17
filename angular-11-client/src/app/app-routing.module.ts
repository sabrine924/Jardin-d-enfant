import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardUserComponent } from './board-user/board-user.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ProfileListComponent } from './profile-list/profile-list.component';
import {AddpostComponent} from "./addpost/addpost.component";
import {PostlistnewComponent} from "./postlistnew/postlistnew.component";
import {PostDetailComponent} from "./post-detail/post-detail.component";
import {UpdateCommentComponent} from "./update-comment/update-comment.component";
import {PostlistadminComponent} from "./postlistadmin/postlistadmin.component";

const routes: Routes = [
  { path: 'retrieve-all-users', component: UserListComponent},
  { path: 'retrieve-all-profiles', component: ProfileListComponent},
  { path: 'user-details/:id', component: UserDetailsComponent},
  { path: 'update-user/:id', component: UpdateUserComponent},
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'user', component: BoardUserComponent },
  { path: 'kindergarden', component: BoardModeratorComponent },
  { path: 'admin', component: BoardAdminComponent },
  {path: 'addpost', component: AddpostComponent},
  {path: 'postlistnew', component: PostlistnewComponent},
  {path: 'post-details/:id' , component: PostDetailComponent},
  {path: 'update-comment/:id', component: UpdateCommentComponent},
  {path: 'comments', component: PostlistnewComponent},
  {path: 'postlistadmin', component: PostlistadminComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
