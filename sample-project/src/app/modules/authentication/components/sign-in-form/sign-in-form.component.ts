import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from 'src/app/services/Authentication/authentication.service';

@Component({
  selector: 'app-sign-in-form',
  templateUrl: './sign-in-form.component.html',
  styleUrls: ['./sign-in-form.component.scss']
})
export class SignInFormComponent {

  public loginForm: FormGroup;
  public passwordFieldType: string = 'password';
  public isSubmitted: boolean = false;

  constructor(
    private fb: FormBuilder,
    private auth: AuthenticationService,
    private router: Router
    ) {

    this.loginForm = this.fb.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }


  togglePasswordVisibility() {
    this.passwordFieldType =
      this.passwordFieldType === 'password' ? 'text' : 'password';
  }

  onSubmit() {
    this.isSubmitted = true;
    console.log(this.loginForm.value);

    if (this.loginForm.valid) {
      this.auth.loginUser(this.loginForm.value)
      .subscribe({
        next: (res) => {
          console.log("[RESPONSE]: ", res);
          if (res.token) {
            localStorage.setItem('token', res.token);
            this.loginForm.reset();
            this.router.navigate(["/"]);
          } else {
            this.loginForm.setErrors({ invalidCredentials: true });
          }
        },
        error: (err) => {
          console.log("[ERROR]: ", err);
        }
      });
    }
  }
}
