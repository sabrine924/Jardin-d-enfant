import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { EmailService } from '../_services/email.service';
import { Email } from './email';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit {
  title = 'gestion des emails';

  email: Email = new Email();
  submitted = false;
  constructor(private emailService: EmailService,
    private router: Router) { }

  ngOnInit(): void {
  }

  gotoEmailform(){
    this.router.navigate(['/admin']);
  }

  onSubmit(form: NgForm){
    this.submitted = true;
    const to = form.value.to;
    const subject = form.value.subject;
    const message = form.value.message;
    this.emailService.email(to, subject, message).subscribe(data => {
      console.log(data);
    })
  }
  /*saveEmail() {
    this.emailService.sendingemail(this.email).subscribe( data =>{
      console.log(data);
      this.gotoEmailform();
    },
    error => console.log(error)
    );
  }*/

}
