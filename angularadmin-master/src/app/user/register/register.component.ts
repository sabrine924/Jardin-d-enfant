import { Component, OnInit } from '@angular/core';
import { AuthService } from 'app/auth/auth.service';
import { SignUpInfo } from 'app/auth/signup-info';



@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  form: any = {};
  signupInfo: SignUpInfo;
  isSignedUp = false;
  isSignUpFailed = false;
  errorMessage = '';
  authService: any;
  constructor() { }

  ngOnInit() {}

  onSubmit() {
    console.log(this.form);

    this.signupInfo = new SignUpInfo(
      this.form.firstname,
      this.form.username,
      this.form.email,
      this.form.lastname,
      this.form.adress,
      this.form.phone,
      this.form.password);
     

    this.authService.signUp(this.signupInfo).subscribe(
      data => {
        console.log(data);
        this.isSignedUp = true;
        this.isSignUpFailed = false;
      },
      error => {
        console.log(error);
        this.errorMessage = error.error.message;
        this.isSignUpFailed = true;
      }
    );
  }
   


}