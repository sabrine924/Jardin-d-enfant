import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Message } from '../message';
import { MessageService } from '../_services/message.service';

@Component({
  selector: 'app-create-message',
  templateUrl: './create-message.component.html',
  styleUrls: ['./create-message.component.css']
})
export class CreateMessageComponent implements OnInit {

  message: Message = new Message();
  submitted = false;
  constructor(private messageService: MessageService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveMessage(){
    this.messageService.createMessage(this.message).subscribe( data =>{
      console.log(data);
      this.gotoMessageList();
    },
    error => console.log(error)
    );
  }
   
  gotoMessageList(){
    this.router.navigate(['/list-message']);
  }

  onSubmit(){
    this.submitted = true;
    this.saveMessage();
  }

}
