import { Component, OnInit } from '@angular/core';
import { TutorialService } from '../_services/tutorial.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Tutorial } from 'src/app/models/tutorial.model';

@Component({
  selector: 'app-tutorial-details',
  templateUrl: './tutorial-details.component.html',
  styleUrls: ['./tutorial-details.component.css']
})
export class TutorialDetailsComponent implements OnInit {
  currentTutorial: Tutorial = {
    id: '',
    prix: '',
    typeOffre: '',
    description: ''
    
  };
  message = '';

  constructor(
    private tutorialService: TutorialService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getTutorial(this.route.snapshot.params.id);
  }

  getTutorial(id: string): void {
    this.tutorialService.get(id)
      .subscribe(
        data => {
          this.currentTutorial = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  

  getOffreByTypeOffre(typeOffre: any): void {
    this.tutorialService.getOffreByTypeOffre(typeOffre)
      .subscribe(
        data => {
          /*this.currentTutorial = data; */
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  
  updatePublished(status: boolean): void {
    const data = {
      id: this.currentTutorial.id,
      prix: this.currentTutorial.prix,
      typeOffre: this.currentTutorial.typeOffre,
      dateDebut: this.currentTutorial.dateDebut,
      dateFin: this.currentTutorial.dateFin,
      description: this.currentTutorial.description,
      published: status
    };

    this.message = '';

    this.tutorialService.update(this.currentTutorial.id, data)
      .subscribe(
        response => {
          
          console.log(response);
          this.message = response.message ? response.message : 'This offer was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  updateTutorial(): void {
    this.message = '';

    this.tutorialService.update(this.currentTutorial.id, this.currentTutorial)
      .subscribe(
        response => {
          console.log(response);
          this.message = response.message ? response.message : 'This offer was updated successfully!';
        },
        error => {
          console.log(error);
        });
  }

  deleteTutorial(): void {
    this.tutorialService.delete(this.currentTutorial.id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/tutorials']);
          
        },
        error => {
          console.log(error);
        });
  }
}
