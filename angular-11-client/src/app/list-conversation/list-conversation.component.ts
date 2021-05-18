import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Conversation } from '../conversation';
import { ConversationService } from '../_services/conversation.service';

@Component({
  selector: 'app-list-conversation',
  templateUrl: './list-conversation.component.html',
  styleUrls: ['./list-conversation.component.css']
})
export class ListConversationComponent implements OnInit {

   conversationTab : any;

  constructor(private conversationService: ConversationService,
    private router: Router) { }

  ngOnInit(): void {

    this.getConversations();
  }
  private getConversations(){
    this.conversationService.getConversationsList()
    .subscribe(data => {
      this.conversationTab = data;
      console.log(this.conversationTab[0].users[0].firstName);
    });
  }

  /*Conversationdetails(id: number){
    this.router.navigate(['detail-conversation', id])
  }*/

  deleteConversation(id: number){
    this.conversationService.deleteConversation(id)
    .subscribe( data => {
      console.log(data);
      this.getConversations();
    })


  }

}
