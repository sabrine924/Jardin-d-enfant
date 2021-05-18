import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { BoardAdminComponent } from './board-admin/board-admin.component';
import { BoardModeratorComponent } from './board-moderator/board-moderator.component';
import { BoardUserComponent } from './board-user/board-user.component';

import { authInterceptorProviders } from './_helpers/auth.interceptor';
import { UserListComponent } from './user-list/user-list.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ProfileListComponent } from './profile-list/profile-list.component';
import { PostComponent } from './post/post.component';
import { PostlistnewComponent } from './postlistnew/postlistnew.component';
import { AddpostComponent } from './addpost/addpost.component';
import { PostDetailComponent } from './post-detail/post-detail.component';
import { CommentPostComponent } from './comment-post/comment-post.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { UpdateCommentComponent } from './update-comment/update-comment.component';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import { PostlistadminComponent } from './postlistadmin/postlistadmin.component';
import { ConversationComponent } from './conversation/conversation.component';
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
import { SidebaradminComponent } from './sidebaradmin/sidebaradmin.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProfileComponent,
    BoardAdminComponent,
    BoardModeratorComponent,
    BoardUserComponent,
    //UserListComponent,
    UserDetailsComponent,
    UpdateUserComponent,
    UserListComponent,
    ProfileListComponent,
    PostComponent,
    PostlistnewComponent,
    AddpostComponent,
    PostDetailComponent,
    CommentPostComponent,
    SidebarComponent,
    UpdateCommentComponent,
    PostlistadminComponent,
    EmailComponent,
    RdvListComponent,
    RdvComponent,
    CreateRdvComponent,
    UpdateRdvComponent,
    RdvDetailsComponent,
    MessageComponent,
    ListMessageComponent,
    //SendMessageComponent,
    //ConversationComponent,
    ListConversationComponent,
    //DetailConversationComponent,
    CreateConversationComponent,
    CreateMessageComponent,
    ConversationComponent,
    SidebaradminComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
  ],
  providers: [authInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
