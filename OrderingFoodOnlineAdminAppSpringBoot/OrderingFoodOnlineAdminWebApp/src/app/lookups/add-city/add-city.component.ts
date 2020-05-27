import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LookupsManagerService } from 'src/app/service/lookups/lookups-manager.service';
import { CityBean, AreaBean } from '../LookupsBeans';

@Component({
  selector: 'app-add-city',
  templateUrl: './add-city.component.html',
  styleUrls: ['./add-city.component.css']
})
export class AddCityComponent implements OnInit {
  city: CityBean = new CityBean();
  constructor(
    private lookupsManagerService: LookupsManagerService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.city.nameAr = ''
    this.city.nameEn = ''
  }

  addCity() {
    this.lookupsManagerService.addNewCity(this.city).subscribe(
      response => {
        this.router.navigate(['cityList'])
      }
    )
  }

  back() {
    this.router.navigate(['cityList']);
  }

}
