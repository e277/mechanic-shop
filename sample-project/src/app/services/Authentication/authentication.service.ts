import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private apiURL: string = "http://localhost:8080/api/v1/"

  constructor(private http: HttpClient) { }

  loginUser(body: object): Observable<any> {
    return this.http.post<any>(this.apiURL + 'auth/signin', body);
  }


  signUpUser(body: object): Observable<any> {
    return this.http.post<any>(this.apiURL + 'auth/signup', body);
  }
}
