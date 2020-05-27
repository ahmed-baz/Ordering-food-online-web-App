import { Component, OnInit } from '@angular/core';

import { BranchBean, ProviderBean } from '../ProviderBeans';
import { ActivatedRoute, Router } from '@angular/router';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';
import { AreaBean } from 'src/app/lookups/LookupsBeans';
import { LookupsManagerService } from 'src/app/service/lookups/lookups-manager.service';

@Component({
  selector: 'app-update-branch',
  templateUrl: './update-branch.component.html',
  styleUrls: ['./update-branch.component.css']
})
export class UpdateBranchComponent implements OnInit {
  branchId: number
  providerId: Number
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

  updatebranch() {
    this.branch.area = this.selectedAreaItem
    this.providerManagerService.updateBranch(this.branch).subscribe(
      response => {
        this.router.navigate(['branchList', this.providerId])
      }
    );
  }
  back() {
    this.router.navigate(['branchList', this.providerId])
  }

  ngOnInit(): void {
    this.branchId = this.route.snapshot.params['branchId'];
    this.branchId
    this.providerManagerService.findBranchById(this.branchId).subscribe(
      data => {
        this.branch = data
        this.providerId = this.branch.provider.id
      }
    );

    this.lookupsManagerService.findAreaList().subscribe(
      data => {
        this.areaList = data
      }
    );
  }



}
