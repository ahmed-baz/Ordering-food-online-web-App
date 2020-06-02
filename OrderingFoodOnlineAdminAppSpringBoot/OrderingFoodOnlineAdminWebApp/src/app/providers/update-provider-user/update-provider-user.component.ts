import { Component, OnInit } from '@angular/core';
import { providerUsersBean, ProviderBean, BranchBean } from '../ProviderBeans';
import { ActivatedRoute, Router } from '@angular/router';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';

@Component({
  selector: 'app-update-provider-user',
  templateUrl: './update-provider-user.component.html',
  styleUrls: ['./update-provider-user.component.css']
})
export class UpdateProviderUserComponent implements OnInit {


  provider: ProviderBean = new ProviderBean()
  providerUser: providerUsersBean = new providerUsersBean();
  selectedBranchItem: BranchBean = new BranchBean()
  branchList: BranchBean[]
  providerUserId: Number
  private providerId: Number = 0
  constructor(

    private route: ActivatedRoute,
    private router: Router,
    private providerManagerService: ProviderManagerService
  ) { }

  updateProviderUser() {
    this.providerUser.branch = this.selectedBranchItem;
    this.providerUser.provider = this.provider
    this.providerManagerService.updateProviderUser(this.providerUser).subscribe(
      response => {
        this.router.navigate(['providerUserList', this.providerUser.branch.id])

      }
    );
  }
  back() {
    this.router.navigate(['providerUserList', this.providerUser.branch.id])
  }

  ngOnInit(): void {
    this.providerUserId = this.route.snapshot.params['providerUserId'];
    this.providerId = this.route.snapshot.params['providerId'];

    this.findProviderUserById(this.providerUserId)
    this.findProviderById(this.providerId)
    this.findBranchListByProviderId(this.providerId)
  }

  findProviderUserById(id) {
    this.providerManagerService.findProviderUserById(this.providerUserId).subscribe(
      data => {
        this.providerUser = data
      }
    );
  }

  findBranchListByProviderId(id) {
    this.providerManagerService.findBranchListByProviderId(id).subscribe(
      data => {
        this.branchList = data
      }
    );
  }

  findProviderById(id) {
    this.providerManagerService.findProviderById(id).subscribe(
      data => {
        this.provider = data
      }
    );
  }

}
