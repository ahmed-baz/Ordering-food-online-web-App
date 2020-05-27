import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ProviderBean, BranchBean } from 'src/app/providers/ProviderBeans';

@Injectable({
  providedIn: 'root'
})
export class ProviderManagerService {

  constructor(
    private http: HttpClient
  ) { }

  findProviderList() {
    let headers = this.getHttpHeaders();
    return this.http.get<ProviderBean[]>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Provider/findProviderList`)
  }

  findProviderById(id) {
    let headers = this.getHttpHeaders();
    return this.http.get<ProviderBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Provider/findProviderById?id=` + id)
  }

  updateProvider(provider) {
    let headers = this.getHttpHeaders();
    return this.http.put<ProviderBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Provider/updateProvider`, provider)
  }

  addProvider(provider) {
    let headers = this.getHttpHeaders();
    return this.http.post<ProviderBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Provider/addProvider`, provider)
  }
  removeProvider(id) {
    let headers = this.getHttpHeaders();
    return this.http.delete(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Provider/removeProvider?id=` + id)
  }

  findBranchListByProviderId(id) {
    let headers = this.getHttpHeaders();
    return this.http.get<BranchBean[]>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Provider/findBranchListByProviderId?id=` + id)
  }

  findBranchById(id) {
    let headers = this.getHttpHeaders();
    return this.http.get<BranchBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Provider/findBranchById?id=` + id)
  }

  addBranch(branch) {
    let headers = this.getHttpHeaders();
    return this.http.post<BranchBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Provider/addBranch`, branch)
  }

  updateBranch(branch) {
    let headers = this.getHttpHeaders();
    return this.http.put<BranchBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Provider/updateBranch`, branch)
  }
  removeBranch(id) {
    let headers = this.getHttpHeaders();
    return this.http.delete(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Provider/removeBranch?id=` + id);
  }




  createBasicAuthenticationHttpHeader() {
    let username = 'root';
    let password = 'root';
    let basicAuthenticationHttpHeaderString = 'Basic ' + window.btoa(username + ':' + password);
    return basicAuthenticationHttpHeaderString;
  }

  getHttpHeaders() {
    let basicAuthenticationHttpHeaderString = this.createBasicAuthenticationHttpHeader();
    let headers = new HttpHeaders(
      {
        Authorization: basicAuthenticationHttpHeaderString
      }
    );
    return headers;
  }
}
