import { Component, OnInit } from '@angular/core';
import { ProviderBean } from '../ProviderBeans';
import { Router } from '@angular/router';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';

@Component({
  selector: 'app-add-provider',
  templateUrl: './add-provider.component.html',
  styleUrls: ['./add-provider.component.css']
})
export class AddProviderComponent implements OnInit {

  constructor(
    private providerManagerService: ProviderManagerService,
    private router: Router
  ) { }

  provider: ProviderBean = new ProviderBean();

  ngOnInit(): void {
  }

  addProvider() {
    this.providerManagerService.addProvider(this.provider).subscribe(
      response => {
        this.router.navigate(['providerList'])
      }
      
    );

  }
  back() {
    this.router.navigate(['providerList'])
  }

}
