import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import {Event} from '../models/event'
import {EventService } from '../_services/event.service';



@Component({
  selector: 'app-create-event',
  templateUrl: './create-event.component.html',
  styleUrls: ['./create-event.component.css']
})
export class CreateEventComponent implements OnInit {

 event: Event = new Event(); 
 submitted = false;


  constructor( private eventService: EventService,private router: Router ){}
   
  ngOnInit() {
  this.submitted=false; 
  }

 /*newEvent(): void {
    this.event = new Event();
  }*/
/*saveEvent(){
   
    this.eventService
    .createEvent(this.event).subscribe(data => {
      console.log(data)
      this.event = new Event();
      this.goToEventList();
    },
    error => {console.log(error)
     
    }
      );
  }

 
 onSubmit(){
    this.submitted = true;
    this.saveEvent(); 

}
goToEventList(){
  this.router.navigate(['/eventlist']);
  
}*/
eventsaveform=new FormGroup({  
 name:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),  
description:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),  
subject:new FormControl('' , [Validators.required , Validators.minLength(5) ] ), 
startHour:new FormControl('' , [Validators.required , Validators.minLength(5) ] ), 
endHour:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
date:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
category:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
location:new FormControl('' , [Validators.required , Validators.minLength(5) ] ),
 jackpotDonation:new FormControl()  
});  
saveEvent(){  
  this.event=new Event();     
  this.event.name=this.EventName?.value;  
  this.event.jackpotDonation=this.jackpotDonation?.value;
  this.event.subject=this.subject?.value;
  this.event.description=this.description?.value;
  this.event.startHour=this.startHour?.value;
  this.event.endHour=this.endHour?.value;
  this.event.date=this.date?.value;
  this.event.category=this.category?.value;
  this.event.location=this.location?.value;
  this.submitted = true;  
  this.save();  
}  
save() {  
  this.eventService.createEvent(this.event)  
    .subscribe(data => console.log(data), error => console.log(error));  
  this.event = new Event();  
}  
get EventName(){  
  return this.eventsaveform.get('name');  
}  

get jackpotDonation(){  
  return this.eventsaveform.get('jackpotDonation');  
} 
get subject(){  
  return this.eventsaveform.get('subject');  
} 
get description(){  
  return this.eventsaveform.get('description');  
} 
get startHour(){  
  return this.eventsaveform.get('startHour');  
} 
get endHour(){  
  return this.eventsaveform.get('endHour');  
} 
get date(){  
  return this.eventsaveform.get('date');  
} 
get category(){  
  return this.eventsaveform.get('category');  
} 
get location(){  
  return this.eventsaveform.get('location');  
} 
addEventForm(){  
  this.submitted=false;  
  this.eventsaveform.reset();  
}  
}


