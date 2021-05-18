import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-rdv',
  templateUrl: './rdv.component.html',
  styleUrls: ['./rdv.component.css']
})
export class RdvComponent implements OnInit {
  title = 'gestion des rendez-vous';

  constructor() { }

  ngOnInit(): void {
  }

}
