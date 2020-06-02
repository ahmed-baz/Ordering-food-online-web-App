import { Component, OnInit } from '@angular/core';
import { BranchBean, ProviderBean, DeliveryAreaBean } from '../ProviderBeans';
import { ActivatedRoute, Router } from '@angular/router';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';
import { LookupsManagerService } from 'src/app/service/lookups/lookups-manager.service';
import { AreaBean } from 'src/app/lookups/LookupsBeans';

@Component({
  selector: 'app-add-delivery-area',
  templateUrl: './add-delivery-area.component.html',
  styleUrls: ['./add-delivery-area.component.css']
})
export class AddDeliveryAreaComponent implements OnInit {

  deliveryArea: DeliveryAreaBean = new DeliveryAreaBean()
  branchId: number
  areaList: AreaBean[]
  branch: BranchBean = new BranchBean()
  selectedAreaItem: AreaBean = new AreaBean()
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private providerManagerService: ProviderManagerService,
    private lookupsManagerService: LookupsManagerService

  ) { }

  addDeliveryArea() {
    this.deliveryArea.areaBean = this.selectedAreaItem
    this.deliveryArea.branchBean = this.branch
    this.providerManagerService.addDeliveryArea(this.deliveryArea).subscribe(
      response => {
        this.router.navigate(['deliveryAreaList', this.branchId])
      }
    );
  }
  back() {
    this.router.navigate(['deliveryAreaList', this.branchId])
  }
  ngOnInit(): void {
    this.branchId = this.route.snapshot.params['branchId'];
    this.findAreaList()
    this.findBranchById()
  }

  findAreaList() {
    this.lookupsManagerService.findAreaList().subscribe(
      data => {
        this.areaList = data
      }
    );
  }

  findBranchById() {
    this.providerManagerService.findBranchById(this.branchId).subscribe(
      data => {
        this.branch = data
      }
    );
  }

}
