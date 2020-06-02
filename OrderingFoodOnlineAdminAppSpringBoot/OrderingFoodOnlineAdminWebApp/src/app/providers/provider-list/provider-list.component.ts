import { Component, OnInit } from '@angular/core';
import { ProviderBean } from '../ProviderBeans';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-provider-list',
  templateUrl: './provider-list.component.html',
  styleUrls: ['./provider-list.component.css']
})
export class ProviderListComponent implements OnInit {

  message: string = ''
  ProviderList: ProviderBean[]
  constructor(
    private providerManagerService: ProviderManagerService,
    private router: Router
  ) { }

  addNewProvider() {
    this.router.navigate(['new-provider'])
  }
  updateProvider(id) {
    this.router.navigate(['update-provider', id])
  }
  removeProvider(id) {
    this.providerManagerService.removeProvider(id).subscribe(
      response => {
        this.refreshProviderList();
        this.message = 'provider deleted successfully';
      }
    );
  }
  viewBranches(id) {
    this.router.navigate(['branchList', id])
  }
  viewCategories(id) {
    this.router.navigate(['categoryList', id])

  }

  ngOnInit(): void {
    this.refreshProviderList();
  }

  refreshProviderList() {
    this.providerManagerService.findProviderList().subscribe(
      data => {
        this.ProviderList = data
      }
    );
  }

}
