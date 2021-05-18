import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { ServiceService } from 'app/service.service';
//import { RdvService } from 'app/service/rdv.service';
import { Rdv } from '../rdv';
import { RdvService } from '../_services/rdv.service';
@Component({
  selector: 'app-rdv-list',
  templateUrl: './rdv-list.component.html',
  styleUrls: ['./rdv-list.component.css']
})
export class RdvListComponent implements OnInit {

  rdvTab : any=[];
  constructor(private rdvService: RdvService,
  private router: Router) { }
  ngOnInit(): void {
    this.getRdvs();
  }
  private getRdvs(){
    this.rdvService.getRdvsList().subscribe(data => {
      for (const rdv of data) {
        rdv.date= new Date(rdv.date).toString();
        this.rdvTab.push(rdv);
      }
      //this.rdvTab = data;
      console.log(this.rdvTab[0].user.firstName);
    });
  }
  Rdvdetails(idRdv: number){
    this.router.navigate(['rdv-details', idRdv])
  }

  updateRdv(idRdv: number){
    debugger
    this.router.navigate(['update-rdv'],{ queryParams: { idRdv: idRdv }});
  }

  deleteRdv(idRdv: number){
    this.rdvService.deleteRdv(idRdv)
    .subscribe( data => {
      console.log(data);
      this.getRdvs();
    })


  }

}
