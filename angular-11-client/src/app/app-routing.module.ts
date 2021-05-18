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
import { CreateConversationComponent } from './create-conversation/create-conversation.component';
import { CreateMessageComponent } from './create-message/create-message.component';
import { CreateRdvComponent } from './create-rdv/create-rdv.component';
import { EmailComponent } from './email/email.component';
import { ListConversationComponent } from './list-conversation/list-conversation.component';
import { ListMessageComponent } from './list-message/list-message.component';
import { MessageComponent } from './message/message.component';
import { RdvDetailsComponent } from './rdv-details/rdv-details.component';
import { RdvListComponent } from './rdv-list/rdv-list.component';
import { RdvComponent } from './rdv/rdv.component';
import { UpdateRdvComponent } from './update-rdv/update-rdv.component';
import { EventListComponent } from './event-list/event-list.component';
import { CreateEventComponent } from './create-event/create-event.component';
import { UpdateEventComponent } from './update-event/update-event.component';
import { DetailsEventComponent } from './details-event/details-event.component';
import { StatEventComponent } from './stat-event/stat-event.component';
import { AgmCoreModule } from '@agm/core';

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
  { path: 'rdv-list', component: RdvListComponent},
  { path: 'create-rdv', component: CreateRdvComponent },
  { path: 'rdvs',component: RdvComponent},
  { path: 'update-rdv/:idRdv', component: UpdateRdvComponent},
  { path: 'rdv-details/:idRdv', component: RdvDetailsComponent},
  { path: 'sendingemail', component: EmailComponent},
  { path: 'message', component: MessageComponent},
  //{ path: 'sendmessage', component: SendMessageComponent},
  { path: 'list-message/:convId', component: ListMessageComponent},
  { path: 'list-conversation', component: ListConversationComponent},
  { path: 'create-conversation', component: CreateConversationComponent},
  { path: 'create-message', component: CreateMessageComponent},
  {path:'eventlist',component:EventListComponent},
  {path:'createevent', component:CreateEventComponent},
  {path: 'update-event', component: UpdateEventComponent},
   {path: 'event-details' ,component: DetailsEventComponent},
   {path: 'statevent' ,component: StatEventComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes),
    AgmCoreModule],
  exports: [RouterModule]
})
export class AppRoutingModule { }
