import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SignInComponent } from './pages/sign-in/sign-in.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SignInFormComponent } from './components/sign-in-form/sign-in-form.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    SignInComponent,
    SignUpComponent,
    SignInFormComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ]
})
export class AuthenticationModule { }
