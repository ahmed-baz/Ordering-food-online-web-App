import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LookupsManagerService } from 'src/app/service/lookups/lookups-manager.service';
import { CityBean, AreaBean } from '../LookupsBeans';


@Component({
  selector: 'app-update-city',
  templateUrl: './update-city.component.html',
  styleUrls: ['./update-city.component.css']
})
export class UpdateCityComponent implements OnInit {

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private lookupsManagerService: LookupsManagerService
  ) { }

  private id: Number;
  city: CityBean = new CityBean();
  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.lookupsManagerService.findCityById(this.id).subscribe(
      data => {
        this.city = data
      }
    );
  }
  update() {
    this.lookupsManagerService.updateCity(this.city).subscribe(
      data => {
        this.router.navigate(['cityList'])
      }

    );

  }
  back() {
    this.router.navigate(['cityList']);
  }

}
