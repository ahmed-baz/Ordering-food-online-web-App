import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private route: ActivatedRoute) { }
  name: String = ""
  welcomeMessageFromService: String = ""

  ngOnInit(): void {
    this.name = this.route.snapshot.params["name"];
  }


  handelSuccessfulResponse(response) {
    this.welcomeMessageFromService = response.message;
  }
  handelErrorResponse(error) {
    this.welcomeMessageFromService = error.error.message;
  }

}
