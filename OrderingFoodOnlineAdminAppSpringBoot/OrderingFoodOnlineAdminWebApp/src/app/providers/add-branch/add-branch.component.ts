import { Component, OnInit } from '@angular/core';

import { BranchBean, ProviderBean } from '../ProviderBeans';
import { ActivatedRoute, Router } from '@angular/router';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';
import { AreaBean } from 'src/app/lookups/LookupsBeans';
import { LookupsManagerService } from 'src/app/service/lookups/lookups-manager.service';

@Component({
  selector: 'app-add-branch',
  templateUrl: './add-branch.component.html',
  styleUrls: ['./add-branch.component.css']
})
export class AddBranchComponent implements OnInit {

  providerId: number
  provider: ProviderBean = new ProviderBean()
  branch: BranchBean = new BranchBean()
  areaList: AreaBean[]
  selectedAreaItem: AreaBean
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private providerManagerService: ProviderManagerService,
    private lookupsManagerService: LookupsManagerService
  ) { }

  addbranch() {
    this.branch.area = this.selectedAreaItem
    this.providerManagerService.addBranch(this.branch).subscribe(
      response => {
        this.router.navigate(['branchList', this.providerId])
      }
    );
  }
  back() {
    this.router.navigate(['branchList', this.providerId])
  }

  ngOnInit(): void {
    this.branch.openAt = new Date()
    console.log(this.branch.openAt)
    this.providerId = this.route.snapshot.params['providerId'];
    this.providerManagerService.findProviderById(this.providerId).subscribe(
      data => {
        this.provider = data
        this.branch.provider = this.provider
      }
    );

    this.lookupsManagerService.findAreaList().subscribe(
      data => {
        this.areaList = data
      }
    );
  }

}
