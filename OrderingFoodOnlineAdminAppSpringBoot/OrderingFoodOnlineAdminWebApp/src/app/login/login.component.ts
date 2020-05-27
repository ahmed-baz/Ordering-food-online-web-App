import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationManagerService } from '../service/authentication/authentication-manager.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  isValid: boolean = false
  userName: string = "";
  password: string = "";
  message: string = 'Invalid user name or password';
  user: User = new User();

  constructor(
    private router: Router,
    private authenticationManagerService: AuthenticationManagerService
  ) {

  }

  checkLogin() {
    this.authenticationManagerService.checkLogin(this.user).subscribe(
      data => {
        this.isValid = true
      })

    if (this.isValid) {
      this.router.navigate(['home', this.userName])
    }
    else {
      this.router.navigate(['login'])
    }
  }

  ngOnInit(): void {
  }

}

export class User {
  public userName: string;
  public password: string
  constructor(
  ) { }
}