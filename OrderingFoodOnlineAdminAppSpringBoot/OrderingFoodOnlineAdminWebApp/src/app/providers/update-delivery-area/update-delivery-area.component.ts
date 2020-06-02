import { Component, OnInit } from '@angular/core';
import { BranchBean, ProviderBean, DeliveryAreaBean } from '../ProviderBeans';
import { ActivatedRoute, Router } from '@angular/router';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';
import { LookupsManagerService } from 'src/app/service/lookups/lookups-manager.service';
import { AreaBean } from 'src/app/lookups/LookupsBeans';



@Component({
  selector: 'app-update-delivery-area',
  templateUrl: './update-delivery-area.component.html',
  styleUrls: ['./update-delivery-area.component.css']
})
export class UpdateDeliveryAreaComponent implements OnInit {

  deliveryArea: DeliveryAreaBean = new DeliveryAreaBean()
  deliveryAreaId: number
  provider: ProviderBean = new ProviderBean()
  branch: BranchBean = new BranchBean()
  areaList: AreaBean[]
  branchList: BranchBean[]
  selectedAreaItem: AreaBean = new AreaBean()
  selectedBranchItem: BranchBean = new BranchBean()
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private providerManagerService: ProviderManagerService,
    private lookupsManagerService: LookupsManagerService

  ) { }

  updateDeliveryArea() {
    this.deliveryArea.areaBean = this.selectedAreaItem
    this.deliveryArea.branchBean = this.selectedBranchItem
    this.providerManagerService.updateDeliveryArea(this.deliveryArea).subscribe(
      response => {
        this.router.navigate(['deliveryAreaList', this.deliveryArea.branchBean.id])

      }
    );
  }
  back() {
    this.router.navigate(['deliveryAreaList', this.deliveryArea.branchBean.id])
  }
  ngOnInit(): void {
    this.deliveryAreaId = this.route.snapshot.params['deliveryAreaId'];
    this.providerManagerService.findDeliveryAreaId(this.deliveryAreaId).subscribe(
      data => {
        this.deliveryArea = data
        this.findAreaList();
        this.findBranchListByProviderId();
      }
    );
  }

  findAreaList() {
    this.lookupsManagerService.findAreaList().subscribe(
      data => {
        this.areaList = data
      }
    );
  }

  findBranchListByProviderId() {
    this.providerManagerService.findBranchListByProviderId(this.deliveryArea.branchBean.provider.id).subscribe(
      data => {
        this.branchList = data
      }
    );
  }

}
