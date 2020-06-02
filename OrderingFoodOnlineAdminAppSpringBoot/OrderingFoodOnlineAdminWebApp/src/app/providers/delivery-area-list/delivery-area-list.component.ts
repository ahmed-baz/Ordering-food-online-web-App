import { Component, OnInit } from '@angular/core';
import { BranchBean, ProviderBean, DeliveryAreaBean } from '../ProviderBeans';
import { ActivatedRoute, Router } from '@angular/router';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';
import { AreaBean } from 'src/app/lookups/LookupsBeans';

@Component({
  selector: 'app-delivery-area-list',
  templateUrl: './delivery-area-list.component.html',
  styleUrls: ['./delivery-area-list.component.css']
})
export class DeliveryAreaListComponent implements OnInit {

  branchId: number = 0
  provider: ProviderBean = new ProviderBean()
  branch: BranchBean = new BranchBean()
  message: string = ''
  deliveryAreaList: DeliveryAreaBean[]
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private providerManagerService: ProviderManagerService,

  ) { }
  updateArea(id) {
    this.router.navigate(['update-deliveryArea', id])
  }
  removeArea(id) {
    this.providerManagerService.removeDeliveryArea(id).subscribe(
      response => {
        this.message = 'Delivery Area deleted successfuly'
        this.refresDeliveryAreaList()
      }
    );
  }
  addNewArea() {
    this.router.navigate(['new-deliveryArea', this.branch.id])
  }
  back() {
    this.router.navigate(['branchList', this.branch.provider.id])
  }
  ngOnInit(): void {
    this.refresDeliveryAreaList();
  }

  refresDeliveryAreaList() {
    this.branchId = this.route.snapshot.params['branchId'];
    this.providerManagerService.findDeliveryAreaListByBranchId(this.branchId).subscribe(
      data => {
        this.deliveryAreaList = data
        this.findBranchById()

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
