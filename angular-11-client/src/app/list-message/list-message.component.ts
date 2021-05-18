import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Message } from '../message';
import { MessageService } from '../_services/message.service';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-list-message',
  templateUrl: './list-message.component.html',
  styleUrls: ['./list-message.component.css']
})
export class ListMessageComponent implements OnInit {

  'convId': number;
  //'messages': Message[];
  messages: any;
  constructor(private messageService: MessageService,
    private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params
    .subscribe(
      (params: Params) => {
        this.convId = +params['convId'];
      }
    );
    console.log(this.convId);
    this.getMessages(this.convId);
  }
  private getMessages(convId: number) {
    this.messageService.getMessagesList(convId).subscribe(data => {
      this.messages = data;
      console.log(this.messages);
    });
  }


}
