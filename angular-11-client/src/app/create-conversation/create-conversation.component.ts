import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Conversation } from '../conversation';
import { ConversationService } from '../_services/conversation.service';

@Component({
  selector: 'app-create-conversation',
  templateUrl: './create-conversation.component.html',
  styleUrls: ['./create-conversation.component.css']
})
export class CreateConversationComponent implements OnInit {

  conversation: Conversation = new Conversation();
  submitted = false;

  constructor(private conversationService: ConversationService,
    private router: Router) { }

  ngOnInit(): void {
  }

 /* saveConversation(){
    this.conversationService.createConversation(users, message)
    .subscribe( data =>{
      console.log(data);
      this.gotoConversationsList();
    },
    error => console.log(error)
    );

}*/

gotoConversationsList(){
  this.router.navigate(['/conversations']);
}

onSubmit(form: NgForm){
  this.submitted = true;
  const users = form.value.users;
  const text = form.value.message;
  let text2 = {text};
  let textString = JSON.stringify(text2);
    let formdata = new FormData();
    formdata.append("message", textString);
    formdata.append("userId", users);
    //formdata.append("conversation_id", 500);
    this.conversationService.createConversation(formdata).subscribe(data=> {
      console.log(data);
    }
    )

  //this.saveConversation();
}
}