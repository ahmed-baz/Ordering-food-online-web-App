import { Component, OnInit } from '@angular/core';
import { providerUsersBean, ProviderBean, BranchBean } from '../ProviderBeans';
import { ActivatedRoute, Router } from '@angular/router';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';

@Component({
  selector: 'app-provider-user-list',
  templateUrl: './provider-user-list.component.html',
  styleUrls: ['./provider-user-list.component.css']
})
export class ProviderUserListComponent implements OnInit {

  providerUserList: providerUsersBean[]
  provider: ProviderBean = new ProviderBean()
  branch: BranchBean = new BranchBean()
  branchId: Number
  providerId: Number
  message: string = ''
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private providerManagerService: ProviderManagerService
  ) { }

  updateProviderUser(id) {
    this.router.navigate(['update-providerUser', this.providerId, id])
  }
  removeProviderUser(id) {
    this.providerManagerService.removeProviderUser(this.branchId).subscribe(
      response => {
        this.refreshProviderUserList()
      }
    );
  }
  addProviderUser() {
    this.router.navigate(['new-providerUser', this.providerId, this.branchId])
  }
  back() {
    this.router.navigate(['branchList', this.providerId])
  }

  ngOnInit(): void {
    this.refreshProviderUserList();
    this.findBranchById();
  }

  refreshProviderUserList() {
    this.branchId = this.route.snapshot.params['branchId'];
    this.providerManagerService.findProviderUserListByBranchId(this.branchId).subscribe(
      data => {
        this.providerUserList = data
      }
    );
  }

  findBranchById() {
    this.branchId = this.route.snapshot.params['branchId'];
    this.providerManagerService.findBranchById(this.branchId).subscribe(
      data => {
        this.branch = data
        this.providerId = this.branch.provider.id
      }
    );
  }

}
