import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Rdv } from 'src/app/rdv';
import { RdvService } from 'src/app/_services/rdv.service';
//import { ServiceService } from 'app/service.service';
//import { Rdv } from '../rdv';

@Component({
  selector: 'app-update-rdv',
  templateUrl: './update-rdv.component.html',
  styleUrls: ['./update-rdv.component.css']
})
export class UpdateRdvComponent implements OnInit {

  'idRdv': number;
  rdv: Rdv = new Rdv();
  'date': string;
  'subject': string;
  'user': any;
  constructor(private rdvService: RdvService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.idRdv = this.route.snapshot.params['idRdv'];
    this.rdvService.getRdvById(this.idRdv).subscribe(data => {
      this.rdv = data;
      console.log(this.rdv);
      this.subject = data.subject;
      this.date = new Date( data.date).toString();
      this.user = data.user.firstName;
    }, error => console.log(error)
    );
  }

  onSubmit(idRdv: number, date: string, subject: string, user: number) {
    const rdv2 = {idRdv, date, subject} 
    const formdata = new FormData();
    formdata.append("rdvs",JSON.stringify(rdv2));
    formdata.append("user", user);
    this.rdvService.updateRdv(formdata)
      .subscribe(data => {
        console.log(data);
        this.rdv = new Rdv();
        this.gotoRdvList();
      }, error => console.log(error));    
    }

  /*updateRdv() {
    this.rdvService.updateRdv(this.rdv)
      .subscribe(data => {
        console.log(data);
        this.rdv = new Rdv();
        this.gotoRdvList();
      }, error => console.log(error));
    
  }*/

  gotoRdvList(){
    this.router.navigate(['/rdvs']);
  }

  getRdvDetail(idRdv:number){
    this.rdvService.getRdvById(idRdv)
      .subscribe(data  => {
       // debugger
        console.log(data)
        this.rdv = data;
      }, (error: any) => console.log(error));
  }
}
