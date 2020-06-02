import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from 'src/app/login/login.component';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationManagerService {

  constructor(
    private http: HttpClient,
  ) { }

  checkLogin(appUser) {
    //let headers = this.getHttpHeaders();
    return this.http.get<Boolean>(`http://127.0.0.1:8081/checkLogin`, appUser);
  }

  isUserLoggedIn() {
    //let user = sessionStorage.getItem('authenticateUser');
    //return !(user === null)
  }

  logout() {
    sessionStorage.removeItem('authenticateUser');
  }

  createBasicAuthenticationHttpHeader() {
    let username = 'root';
    let password = 'root';
    let basicAuthenticationHttpHeaderString = 'Basic ' + window.btoa(username + ':' + password);
    return basicAuthenticationHttpHeaderString;
  }

  getHttpHeaders() {
    let basicAuthenticationHttpHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders(
      {
        Authorization: basicAuthenticationHttpHeaderString
      }
    );
    return headers;
  }
}
