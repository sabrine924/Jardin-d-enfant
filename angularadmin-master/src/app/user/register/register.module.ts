
import { NgModule } from '@angular/core';
import { RegisterRoutingModule } from './register-routing/register-routing.module';
import { RegisterComponent } from './register.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
@NgModule({
  imports: [
    RegisterRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [
     RegisterComponent
     ],
  providers: []
})
export class RegisterModule { }
