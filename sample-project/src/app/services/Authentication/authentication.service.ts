import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private apiURL = 'http://localhost:8080/api/v1/';

  constructor(private http: HttpClient) { }

  loginUser(body: object): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<any>(`${this.apiURL}auth/signin`, body, { headers });
  }

  signUpUser(body: object): Observable<any> {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    return this.http.post<any>(`${this.apiURL}auth/signup`, body, { headers });
  }

}
