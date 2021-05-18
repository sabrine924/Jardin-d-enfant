import { Component, OnInit } from '@angular/core';
import { ActivatedRoute , Router } from '@angular/router';
import {EventService } from '../_services/event.service';
import {Event} from '../models/event'
import {Location} from '../models/location';
import { from } from 'rxjs';


@Component({
  selector: 'app-details-event',
  templateUrl: './details-event.component.html',
  styleUrls: ['./details-event.component.css']
})
export class DetailsEventComponent implements OnInit {
 
  event: Event = new Event;
  'events': Event;
  public 'idEvent': number;
  'comments': Comment;
  'idComment':number;
  title = ' ** Sabrine ***';
  lat = 36.968574;
  lng = 10.121986;



 tabVille: Array<Location> =  [
   {country : "Tunis", data :{ lat:36.80735, lng:10.18119}},
  {country : "Kairouan", data :{ lat:  35.72797, lng: 10.10325 }},
   {country : "kef", data :{ lat: 36.16816, lng: 8.70921 }},
   {country : "Sfax", data :{  lat:  34.73775, lng: 10.75961,  } },
   {country : "Gafsa", data :{  lat:   33.88836, lng: 10.09796,  } },
   {country : "Ariana", data :{  lat:  36.86753, lng: 10.16609,  } },
   {country : "Sousse", data :{  lat:  35.82477, lng:10.63021,  } },
   {country : "SidiBouzid", data :{  lat: 35.04130, lng: 9.48854,  } },
   {country : "Msaken", data :{  lat:  35.72628, lng: 10.57958,  } },
   {country : "Ben Arous ", data :{  lat:  36.75611, lng: 10.22761,  } },
   {country : "Manouba  ", data :{  lat:  36.80910, lng: 10.08630,  } },
   {country : "Jendouba ", data :{  lat:  36.52285, lng: 8.76981,  } },
   {country : "Monastir ", data :{  lat:  35.76679, lng: 10.80941,  } },
   {country : "Nabeul", data :{  lat:  36.46430, lng: 10.73292,  } },
   {country : "Kasserine", data :{  lat:  35.17182, lng: 8.83020,  } },
   {country : "Bizerte ", data :{  lat:  37.0354339, lng: 9.6393259,  } },
   {country : "Beja", data :{  lat:  36.73, lng: 9.15,  } },
   {country : "Gabes ", data :{  lat:  33.83427, lng: 10.09718,  } },
   {country : "Kebili ", data :{  lat:  33.70721, lng: 8.97156,  } },
  {country : "Tabarka ", data :{  lat:  36.95607, lng: 8.74135,  } },
  {country : "Mahdia ", data :{  lat:  35.50234, lng: 11.04604,  } },
  {country : "Nabeul  ", data :{  lat:  36.45458, lng: 10.73877 } },
  {country : "Kelibia", data :{  lat:  36.850005, lng: 11.101160 } },
  {country : "Manzel Bourguiba ", data :{  lat:  36.11762, lng: 9.36248 } },
  {country : "Zahra  ", data :{  lat:  36.75416, lng: 10.30702} },
  {country : "Zaghouan   ", data :{  lat:  36.26301, lng: 9.99416} },
  {country : "Ras Jebel   ", data :{  lat:  37.21608, lng: 10.11401} },
   ];  
     


 

  constructor(private route: ActivatedRoute, private eventService: EventService , private router: Router,) { }

  ngOnInit(): void {
   
    this.event = new  Event();
    this.idEvent = this.route.snapshot.params['idEvent'];
    this.eventService.getEvent(this.idEvent).subscribe(
      (data) => {
        console.log(data);
        this.event = data;
      },
      (error) => console.log(error)
    );
    
     this.route.queryParams.subscribe(params =>{
      this.idEvent = params.idEvent
      })
      console.log(this.idEvent)
      this.getEventDetail(Number(this.idEvent))

 
  }
 
  getEventDetail(idEvent:number){
    console.log("idEvent",idEvent);
    
    this.eventService.getEvent(idEvent)
      .subscribe(data  => {
        console.log("data",data)
        this.event = data;
        this.findCountry( this.event.location)
      }, (error: any) => console.log(error));
  }

  findCountry( location :any){
    this.tabVille.forEach( (item, index) => {
      if(location === item.country)
        this.lat = item.data.lat;
        this.lng = item.data.lng;
        return;
    })

  }


  list() {
    this.router.navigate(["eventlist"]);
  }

}