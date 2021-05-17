import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Rdv } from 'src/app/rdv';
import { RdvService } from 'src/app/_services/rdv.service';
//import { ServiceService } from 'app/service.service';
//import { Rdv } from '../rdv';

@Component({
  selector: 'app-create-rdv',
  templateUrl: './create-rdv.component.html',
  styleUrls: ['./create-rdv.component.css']
})
export class CreateRdvComponent implements OnInit {

  rdv: Rdv = new Rdv();
  submitted = false;
  constructor(private rdvService: RdvService,
    private router: Router) { }

  ngOnInit(): void {
  }

  /*saveRdv(){
    this.rdvService.createRdv(this.rdv).subscribe( data =>{
      console.log(data);
      this.gotoRdvList();
    },
    error => console.log(error)
    );
  }*/

  gotoRdvList(){
    this.router.navigate(['/rdv-list']);
  }

  onSubmit(form: NgForm){
    this.submitted = true;
    const date = form.value.date;
    const subject = form.value.subject;
    const user = form.value.user;
    const rdv = {date, subject};
    let rdvString = JSON.stringify(rdv);
    let formdata = new FormData();
    formdata.append("rdvs", rdvString);
    formdata.append("user", user);
    this.rdvService.createRdv(formdata).subscribe(data=> {
      console.log(data);
    })
    console.log(date);
  //this.saveRdv();

  }
}
