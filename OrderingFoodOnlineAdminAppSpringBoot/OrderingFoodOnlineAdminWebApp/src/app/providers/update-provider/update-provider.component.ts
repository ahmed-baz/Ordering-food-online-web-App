import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ProviderManagerService } from 'src/app/service/providers/provider-manager.service';
import { ProviderBean } from '../ProviderBeans';

@Component({
  selector: 'app-update-provider',
  templateUrl: './update-provider.component.html',
  styleUrls: ['./update-provider.component.css']
})
export class UpdateProviderComponent implements OnInit {



  constructor(
    private providerManagerService: ProviderManagerService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  provider: ProviderBean = new ProviderBean();
  providerId: number

  ngOnInit(): void {
    this.providerId = this.route.snapshot.params['providerId'];
    this.providerManagerService.findProviderById(this.providerId).subscribe(
      data => {
        this.provider = data
      }

    );
  }

  updateProvider() {
    this.providerManagerService.updateProvider(this.provider).subscribe(
      response => {
        this.router.navigate(['providerList'])
      }

    );

  }
  back() {
    this.router.navigate(['providerList'])
  }


}
