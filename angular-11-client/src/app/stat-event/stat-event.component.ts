import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import { Label } from 'ng2-charts';
import { Category } from '../models/category';
import { EventService } from '../_services/event.service';

@Component({
  selector: 'app-stat-event',
  templateUrl: './stat-event.component.html',
  styleUrls: ['./stat-event.component.css']
})
export class StatEventComponent implements OnInit {
 


  barChartOptions: ChartOptions = {
    responsive: true,
  };
  barChartLabels: Label[] = [];//['Animations', 'Sortie', 'Ateliers', 'Donation'];
  barChartType: ChartType = 'bar';
  barChartLegend = true;
  barChartPlugins = [];

  barChartData: ChartDataSets[] = [];
  // { data: [3, 3, 20, 6], label: 'Events statistics ' }
  //{ data: [], label: 'Events statistics ' }
  //]//;

  category:Category[] = [];
 

  constructor(private eventService: EventService,private http: HttpClient, private router: Router) {}

  ngOnInit() {
  
    this.eventService.getStatEvent().subscribe(data =>{
      var _data : any = []
      data.forEach( (item, index) => {
        this.barChartLabels.push(item.name);
        _data.push(item.numberc);              
      });

      this.barChartLabels.push('');
      _data.push(0);


      this.barChartData = [{ data: _data, label: 'Events statistics ' }];

      //debugger
    })
  
  
  }
  list() {
    this.router.navigate(["eventlist"]);
  }

}



