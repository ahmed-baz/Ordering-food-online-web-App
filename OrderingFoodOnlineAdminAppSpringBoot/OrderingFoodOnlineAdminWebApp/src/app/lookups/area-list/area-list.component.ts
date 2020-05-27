import { Component, OnInit } from '@angular/core';
import { CityBean, AreaBean } from '../LookupsBeans';
import { Router, ActivatedRoute } from '@angular/router';
import { LookupsManagerService } from 'src/app/service/lookups/lookups-manager.service';

@Component({
  selector: 'app-area-list',
  templateUrl: './area-list.component.html',
  styleUrls: ['./area-list.component.css']
})
export class AreaListComponent implements OnInit {

  areaList: AreaBean[];
  city: CityBean = new CityBean();
  private id: number
  message: String = ''
  constructor(
    private lookupsManagerService: LookupsManagerService,
    private route: ActivatedRoute,
    private router: Router

  ) { }

  addNewArea() {
    this.router.navigate(['new-area', this.id])
  }
  updateArea(id) {
    this.router.navigate(['update-area', this.id, id])
  }
  removeArea(id) {
    this.lookupsManagerService.removeAreaById(id).subscribe(
      response => {
        this.refreshAreaList();
        this.message = 'area deleted successfully';
      }
    );
  }
  back() {
    this.router.navigate(['cityList'])
  }

  refreshAreaList() {
    this.id = this.route.snapshot.params['id'];
    this.lookupsManagerService.findCityById(this.id).subscribe(
      data => {
        this.city = data
      }
    );

    this.lookupsManagerService.findAreaListByCityId(this.id).subscribe(
      data => {
        this.areaList = data
      }
    );
  }

  ngOnInit(): void {
    this.refreshAreaList()
  }

}
