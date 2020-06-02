import { Component, OnInit } from '@angular/core';
import { BranchBean, ProviderBean } from '../ProviderBeans';
import { ActivatedRoute, Router } from '@angular/router';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';

@Component({
  selector: 'app-branch-list',
  templateUrl: './branch-list.component.html',
  styleUrls: ['./branch-list.component.css']
})
export class BranchListComponent implements OnInit {

  providerId: number
  provider: ProviderBean = new ProviderBean()
  message: string = ''
  branchList: BranchBean[]
  branch: BranchBean = new BranchBean()
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private providerManagerService: ProviderManagerService

  ) { }
  back() {
    this.router.navigate(['providerList'])
  }
  addBranch() {
    this.router.navigate(['new-branch', this.providerId])
  }
  viewDeliveryArea(id) {
    this.router.navigate(['deliveryAreaList', id])
  }
  viewUsers(id) {
    this.router.navigate(['providerUserList', id])
  }
  updateBranch(id) {
    this.router.navigate(['update-branch', this.providerId, id])
  }
  removeBranch(id) {
    this.providerManagerService.removeBranch(id).subscribe(
      response => {
        this.refreshBranchList();
        this.message = 'Branch removed successfully'
      }
    );

  }
  ngOnInit(): void {
    this.refreshBranchList();
    this.providerManagerService.findProviderById(this.providerId).subscribe(
      data => {
        this.provider = data
      }
    );
  }

  refreshBranchList() {
    this.providerId = this.route.snapshot.params['providerId'];
    this.providerManagerService.findBranchListByProviderId(this.providerId).subscribe(
      data => {
        this.branchList = data
      }
    );
  }

}
