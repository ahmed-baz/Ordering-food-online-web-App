import { Component, OnInit } from '@angular/core';
import { CityBean, AreaBean } from '../LookupsBeans';
import { Router, ActivatedRoute } from '@angular/router';
import { LookupsManagerService } from 'src/app/service/lookups/lookups-manager.service';

@Component({
  selector: 'app-add-area',
  templateUrl: './add-area.component.html',
  styleUrls: ['./add-area.component.css']
})
export class AddAreaComponent implements OnInit {

  city: CityBean = new CityBean();
  area: AreaBean = new AreaBean();
  private cityId: number = 0;

  constructor(
    private lookupsManagerService: LookupsManagerService,
    private router: Router,
    private route: ActivatedRoute
  ) { }


  addNewArea() {
    this.lookupsManagerService.addNewArea(this.area).subscribe(
      response => {
        this.router.navigate(['areaList', this.cityId])
      }
    )
  }
  back() {
    this.router.navigate(['areaList', this.cityId]);
  }
  ngOnInit(): void {
    this.area.city = new CityBean();
    this.area.nameAr = ''
    this.area.nameEn = ''

    this.cityId = this.route.snapshot.params['id'];
    this.lookupsManagerService.findCityById(this.cityId).subscribe(
      data => {
        this.area.city = data
      }
    );
  }



}
