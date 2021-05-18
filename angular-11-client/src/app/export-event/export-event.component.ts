import { Component, OnInit } from '@angular/core';
import { EventService } from '../event.service';

@Component({
  selector: 'app-export-event',
  templateUrl: './export-event.component.html',
  styleUrls: ['./export-event.component.css']
})
export class ExportEventComponent implements OnInit {

  constructor(private eventService : EventService) { }

  ngOnInit(): void {
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
}
