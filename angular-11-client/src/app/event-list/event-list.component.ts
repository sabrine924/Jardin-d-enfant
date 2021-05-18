import { Component, OnInit } from '@angular/core';
import {EventService}  from '../_services/event.service'
import { ActivatedRoute, Router } from '@angular/router';
import {Event} from '../models/event';
import { Observable, Subject } from 'rxjs';
import { FormControl, FormGroup ,Validators } from '@angular/forms';
@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.css']
})
export class EventListComponent implements OnInit {



  constructor( private eventService: EventService,
    private router: Router ,private route: ActivatedRoute, ) { }
  //totalRecords!: number;
  //page: number = 1;
  //events: Event[] = [];
  public name: string = ''; 
 public location: string = '';
  public category: string = '';
 // emp:any;  
  //'eventlist': any;
  /*model : any={}; 
  public 'date2' : Date;
  public 'date1' : Date;
  p: number = 1;*/
  /*model : any={};
  public 'date2' : Date;
  public 'date1' : Date;*/
  p: number = 1;
  model : any={};
  /*public 'date2' : Date;
  public 'date1' : Date;
  /*model : any={};
  public 'date2' : Date;
  public 'date1' : Date;
  p: number = 1;*/
  /*model : any={};
  public 'date2' : Date;
  public 'date1' : Date;
  p: number = 1;*/
  /*model : any={};
  public 'date2' : Date;
  public 'date1' : Date;*/
  //p: number = 1;
  /*model : any={};
  public 'date2' : Date;
  public 'date1' : Date;
  p: number = 1;
  /*model : any={};
  public 'date2' : Date;
  public 'date1' : Date;
  p: number = 1;*/
//'events': Observable<Event[]>; 
  eventsArray: any[] = [];  
  dtOptions: DataTables.Settings = {};  
 dtTrigger: Subject<any>= new Subject(); 
'events' :any ;
  event : Event=new Event();  
  deleteMessage=false;  
  eventlist:any;
  isupdated = false; 

 
  

  ngOnInit() {

   this.dtOptions = {
      pagingType: 'full_numbers',
      pageLength: 3,
      processing: true
    };
   
  
    /*this.isupdated=false;  
    this.dtOptions = {  
      pageLength: 6,  
      stateSave:true,  
      lengthMenu:[[6, 16, 20, -1], [6, 16, 20, "All"]],  
      processing: true  
      
    };  */   
    this.eventService.getEventsList().subscribe(data => {
      console.log(data)
        this.events = data ;
   
    this.dtTrigger.next();  
      })  
    
    //this.getEvents();
    //this.reloadData();
    

    }
 
    deleteEvent(idEvent: number) {  
      this.eventService.deleteEvent(idEvent)
        .subscribe(  
          data => {  
            console.log(data);  
            this.deleteMessage=true;  
            this.eventService.getEventsList().subscribe(data =>{  
              this.events= data;
              })  
          },  
          error => console.log(error));  
    }  

   /* updateEvent(idEvent: number){  

      this.eventService.getEvent(idEvent)
      .subscribe
      
      (data =>{  
  
        this.eventlist= data
    debugger
        }, 
        error => console.log(error));     
    }  
    
    eventupdateform=new FormGroup({  
      
      idEvent:new FormControl(),
      name:new FormControl(),
      jackpotDonation:new FormControl()  ,
      description:new FormControl(),  
      subject:new FormControl( ), 
      startHour:new FormControl(), 
      endHour:new FormControl( ),
      date:new FormControl(),
      category:new FormControl( ),
      location:new FormControl(),
    });  

    updateStu(){  
      this.event=new Event();  
    this.event.idEvent=this.idEvent?.value;   
    this.event.name=this.EventName?.value;  
     this.event.jackpotDonation=this.jackpotDonation?.value;
     this.event.description=this.description?.value; 
     this.event.subject=this.subject?.value; 
     this.event.startHour=this.startHour?.value; 
     this.event.endHour=this.endHour?.value; 
     this.event.date=this.date?.value; 
     //this.event.location=this.location?.value;
     this.event.category=this.category?.value;
     //console.log(this.location?.value);  
    // console.log(this.category?.value);  
      
    
     this.eventService.updateEvent( this.event.idEvent , this.event).subscribe(  
      _data => {       
        this.isupdated=true;
        this.eventService.getEventsList().subscribe(data =>{           
         
          this.events = data ;
       
          })  
      },  
      error => console.log(error));  
   
    }  


    get EventName(){  
      return this.eventupdateform.get('name');  
    }  
    
    get jackpotDonation(){  
      return this.eventupdateform.get('jackpotDonation');  
    } 
    get subject(){  
      return this.eventupdateform.get('subject');  
    } 
    get description(){  
      return this.eventupdateform.get('description');  
    } 
    get startHour(){  
      return this.eventupdateform.get('startHour');  
    } 
    get endHour(){  
      return this.eventupdateform.get('endHour');  
    } 
    get date(){  
      return this.eventupdateform.get('date');  
    } 
    get category(){  
      return this.eventupdateform.get('category');  
    } 
    /*get location(){  
      return this.eventupdateform.get('location');  
    } 
    get  idEvent(){  
      return this.eventupdateform.get(' idEvent');  
    } */


    changeisUpdate(){  
      this.isupdated=false;  
    }  
    eventDetails(idEvent: number){
      this.router.navigate(['event-details'], { queryParams: { idEvent: idEvent }});
    }

    updateEvent1(idEvent: number){
      this.router.navigate(['update-event'],{ queryParams: { idEvent: idEvent }} );
    }
    

  exportEventsPdf(){
      this.eventService.exportPDFEvent().subscribe(x => {
     const blob = new Blob([x], {type: 'application/pdf'});
     if(window.navigator && window.navigator.msSaveOrOpenBlob){
       window.navigator.msSaveOrOpenBlob(blob);
       return;
     }
  
     const data = window.URL.createObjectURL(blob);
     const link = document.createElement('a');
     link.href = data;
     link.download = 'event.pdf';
     link.dispatchEvent(new MouseEvent('click', {bubbles: true,cancelable:true,view:window}));
     setTimeout(function(){
       window.URL.revokeObjectURL(data);
       link.remove();
     }, 100 );
      });
    }
    public findUserByLocation() {
      let resp = this.eventService.getEventByLocation(this.location);
      resp.subscribe((data) => (this.events= data));
    }
    public findEventByCategory(){
      let resp = this.eventService.getEventByCategory(this.category);
      console.log(this.category)
  
      resp.subscribe((data) => (this.events = data));
    }


    
    findEventByName(){
      this.eventService.getEventByName(this.name).subscribe(data => {
        console.log(data)
          this.events = data 
  
        });
    }











  /* reloadData() {
      this.events = this.eventService.getEventsList();
      this.events.subscribe((data: any) => (this.events = data));
    }
   
   private getEvents(){
     this.eventService.getEventsList().subscribe(data => {
      console.log(data)
        this.events = data 
        //this.showdata(); 
      });
    
    }


   /* deleteEvent(idEvent: number){
      this.eventService.deleteEvent(idEvent)
      .subscribe( data => {
        console.log(data);
        this.getEvents();
      })
  }

  updateEvent(idEvent: number){
    this.router.navigate(['update-event'],{ queryParams: { idEvent: idEvent }} );
  }

  /*eventDetails(idEvent: number){
    this.router.navigate(['event-details'], { queryParams: { idEvent: idEvent }});
  }*/

 /* exportEventsPdf(){
    this.eventService.exportPDFEvent().subscribe(x => {
   const blob = new Blob([x], {type: 'application/pdf'});
   if(window.navigator && window.navigator.msSaveOrOpenBlob){
     window.navigator.msSaveOrOpenBlob(blob);
     return;
   }

   const data = window.URL.createObjectURL(blob);
   const link = document.createElement('a');
   link.href = data;
   link.download = 'event.pdf';
   link.dispatchEvent(new MouseEvent('click', {bubbles: true,cancelable:true,view:window}));
   setTimeout(function(){
     window.URL.revokeObjectURL(data);
     link.remove();
   }, 100 );
    });*/
  }


  /*findEventByName(){
    this.eventService.getEventByName(this.name).subscribe(data => {
      console.log(data)
        this.events = data 

      });
  }
  public findUserByLocation() {
    let resp = this.eventService.getEventByLocation(this.location);
    resp.subscribe((data) => (this.events= data));
  }
  public findEventByCategory(){
    let resp = this.eventService.getEventByCategory(this.category);
    console.log(this.category)

    resp.subscribe((data) => (this.events = data));
  }
 public  findEventBetweentwodates(){
  let resp    =   this.eventService.getEventbetween2dates(this.date1,this.date2);
  console.log(resp)
  console.log(this.date1,this.date2)
  console.log(resp)

    resp.subscribe((data) => (this.events= data));
    console.log(resp);

  }*/
 /* showdata()  
  {  
    this.eventService.showdata().subscribe((res: any) => {  
      this.emp=res;   
      console.log(this.emp);   
  })  
  }*/
  /*searchdata() {  
    debugger;  
     this.eventService.searhhdata(this.model).subscribe((res: any) => {  
             
         this.emp=res;   
         console.log(this.emp);   
     })  
   } */
   /*searchBetweenDates(){
    if(this.from!=undefined&&this.to!=undefined)
    {
     this.backAllflag=true;
     this.eventService.GetBetweenTwoDates(this.from,this.to).subscribe(res=>{
       if(res==null||res.length==0)
       {
         this.Toaster.info("search result empty")
         this.events=[];
       }
      
     },err=>{
       this.Toaster.error("something wrong!")
     });
    }
    

}*/


