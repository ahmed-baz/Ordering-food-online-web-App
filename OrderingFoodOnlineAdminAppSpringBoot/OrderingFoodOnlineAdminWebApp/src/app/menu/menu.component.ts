import { Component, OnInit } from '@angular/core';
import { AuthenticationManagerService } from '../service/authentication/authentication-manager.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(
    private authenticationManagerService: AuthenticationManagerService,
    private router: Router
  ) { }

  isUserLoggedIn: boolean = false;

  ngOnInit(): void {
    let isUserLoggedIn = this.authenticationManagerService.isUserLoggedIn();
  }

  logout() {
    this.authenticationManagerService.logout();
    this.router.navigate(['login'])
  }

}
