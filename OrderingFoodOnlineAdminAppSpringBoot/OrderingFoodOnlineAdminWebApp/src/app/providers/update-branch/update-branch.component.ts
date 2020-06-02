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
    this.branch.provider = this.provider
    console.log(this.branch.openAt)
    console.log(this.branch.closeAt)
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
    this.providerId = this.route.snapshot.params['providerId'];

    this.findProviderById();
    this.findBranchById();
    this.findAreaList();

  }

  findProviderById() {
    this.providerManagerService.findProviderById(this.providerId).subscribe(
      data => {
        this.provider = data
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

  findAreaList() {
    this.lookupsManagerService.findAreaList().subscribe(
      data => {
        this.areaList = data
      }
    );
  }



}
