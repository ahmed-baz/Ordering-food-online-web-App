import { Component, OnInit } from '@angular/core';
import { CityBean, AreaBean } from '../LookupsBeans';
import { Router, ActivatedRoute } from '@angular/router';
import { LookupsManagerService } from 'src/app/service/lookups/lookups-manager.service';

@Component({
  selector: 'app-update-area',
  templateUrl: './update-area.component.html',
  styleUrls: ['./update-area.component.css']
})
export class UpdateAreaComponent implements OnInit {

  public cityList: CityBean[];
  city: CityBean = new CityBean();
  area: AreaBean = new AreaBean();
  private cityId: number
  private areaId: number
  constructor(
    private lookupsManagerService: LookupsManagerService,
    private router: Router,
    private route: ActivatedRoute
  ) { }


  updateArea() {
    this.area.cityBean = this.city
    this.lookupsManagerService.updateArea(this.area).subscribe(
      response => {
        this.router.navigate(['areaList', this.cityId])
      }
    )
  }
  back() {
    this.router.navigate(['areaList', this.cityId]);
  }
  ngOnInit(): void {
    this.cityId = this.route.snapshot.params['cityId'];
    this.areaId = this.route.snapshot.params['areaId'];
    this.lookupsManagerService.findAreaById(this.areaId).subscribe(
      data => {
        this.area = data
      }
    );

    this.lookupsManagerService.findCityById(this.cityId).subscribe(
      data => {
        this.city = data
      }
    );

    this.lookupsManagerService.findCityList().subscribe(
      data => {
        this.cityList = data
      }
    );
  }



}
