import { Component, OnInit } from '@angular/core';
import { AuthenticationManagerService } from '../service/authentication/authentication-manager.service';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(
  ) { }

  ngOnInit(): void {
  }

}
