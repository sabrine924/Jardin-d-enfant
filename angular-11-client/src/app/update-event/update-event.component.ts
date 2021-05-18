import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {Event} from '../models/event';
import { EventService } from '../_services/event.service';

@Component({
  selector: 'app-update-event',
  templateUrl: './update-event.component.html',
  styleUrls: ['./update-event.component.css']
})
export class UpdateEventComponent implements OnInit {


 'eventId': number;
  event: Event = new Event();
  constructor(private route: ActivatedRoute,
    private eventService: EventService,
    private router: Router) { }

  ngOnInit(): void {
    this.event= new Event();
    //this.idEvent = this.route.snapshot.params['idEvent'];
    this.route.queryParams.subscribe(params =>{
    this.eventId = params.idEvent
    })
    console.log(this.eventId)
    this.getEventDetai(Number(this.eventId))

  }
updateEvent() {
    this.eventService.updateEvent1(this.event)
      .subscribe(data => {
        console.log(data);
        this.event = new Event();
        this.gotoList();
      }, error => console.log(error));
    

}  
onSubmit() {

this.updateEvent();
   
}

gotoList() {
  this.router.navigate(['/eventlist']);
  }

  getEventDetai(eventId:number){
    this.eventService.getEvent(eventId)
      .subscribe(data  => {
        console.log(data)
        this.event = data;
      }, (error: any) => console.log(error));
  }

  list() {
    this.router.navigate(["eventlist"]);
  }
}
