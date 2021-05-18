import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Rdv } from 'src/app/rdv';
import { RdvService } from 'src/app/_services/rdv.service';
//import { ServiceService } from 'app/service.service';
//import { Rdv } from '../rdv';

@Component({
  selector: 'app-rdv-details',
  templateUrl: './rdv-details.component.html',
  styleUrls: ['./rdv-details.component.css']
})
export class RdvDetailsComponent implements OnInit {

  'idRdv': number;
  rdv!: Rdv;
  constructor(private route: ActivatedRoute, private rdvService: RdvService) { }

  ngOnInit(): void {
    this.idRdv = this.route.snapshot.params['idRdv'];
    this.rdv = new Rdv();
    this.rdvService.getRdvById(this.idRdv).subscribe( data => {
      this.rdv = data;
    });
  }

}
