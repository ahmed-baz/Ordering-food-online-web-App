import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LookupsManagerService } from 'src/app/service/lookups/lookups-manager.service';
import { CityBean ,AreaBean } from '../LookupsBeans';

@Component({
  selector: 'app-city-list',
  templateUrl: './city-list.component.html',
  styleUrls: ['./city-list.component.css']
})
export class CityListComponent implements OnInit {


  message: string = ''

  constructor(
    private lookupsManagerService: LookupsManagerService, private router: Router
  ) { }

  cityList: CityBean[];
  removeCity(id) {
    this.lookupsManagerService.removeCityById(id).subscribe(
      response => {
        this.refreshCityList();
        this.message = 'City deleted successfully';
      }
    );
  }
  updateCity(id) {
    this.router.navigate(['update-city', id]);
  }

  handelSuccessfulResponse(response) {
    this.lookupsManagerService = response.message;
  }
  handelErrorResponse(error) {
    this.lookupsManagerService = error.error.message;
  }


  ngOnInit(): void {
    this.refreshCityList();
  }

  refreshCityList() {
    this.lookupsManagerService.findCityList().subscribe(
      response => { this.cityList = response }
    );
  }

  addNewCity() {
    this.router.navigate(['new-city']);
  }

  viewCity(id) {
    this.router.navigate(['areaList', id]);
  }

}

