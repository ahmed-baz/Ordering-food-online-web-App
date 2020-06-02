import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ProviderBean, BranchBean, DeliveryAreaBean, providerUsersBean, CategoryBean } from 'src/app/providers/ProviderBeans';

@Injectable({
  providedIn: 'root'
})
export class ProviderManagerService {

  constructor(
    private http: HttpClient
  ) { }

  findProviderList() {
    //https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/
    return this.http.get<ProviderBean[]>(`http://127.0.0.1:8081/Provider/findProviderList`)
  }

  findProviderById(id) {
    return this.http.get<ProviderBean>(`http://127.0.0.1:8081/Provider/findProviderById?id=` + id)
  }

  findProviderWithDetailsById(id) {
    return this.http.get<ProviderBean>(`http://127.0.0.1:8081/Provider/findProviderWithDetailsById?id=` + id)
  }

  findDeliveryAreaId(id) {
    return this.http.get<DeliveryAreaBean>(`http://127.0.0.1:8081/Provider/findDeliveryAreaById?id=` + id)
  }

  findDeliveryAreaListByBranchId(id) {
    return this.http.get<DeliveryAreaBean[]>(`http://127.0.0.1:8081/Provider/findDeliveryAreaListByBranchId?id=` + id)
  }

  findBranchListByProviderId(id) {
    return this.http.get<BranchBean[]>(`http://127.0.0.1:8081/Provider/findBranchListByProviderId?id=` + id)
  }

  findBranchById(id) {
    return this.http.get<BranchBean>(`http://127.0.0.1:8081/Provider/findBranchById?id=` + id)
  }

  findBranchWithDetailsById(id) {
    return this.http.get<BranchBean>(`http://127.0.0.1:8081/Provider/findBranchWithDetailsById?id=` + id)
  }

  findProviderUserListByBranchId(id) {
    return this.http.get<providerUsersBean[]>(`http://127.0.0.1:8081/Provider/findProviderUserListByBranchId?id=` + id)
  }

  findProviderUserById(id) {
    return this.http.get<providerUsersBean>(`http://127.0.0.1:8081/Provider/findProviderUserById?id=` + id)
  }

  findCategoryList() {
    return this.http.get<CategoryBean[]>(`http://127.0.0.1:8081/Provider/findCategoryList`)
  }

  findCategoryListByProviderId(id) {
    return this.http.get<CategoryBean[]>(`http://127.0.0.1:8081/Provider/findCategoryListByProviderId?id=` + id)
  }

  findCategoryById(id) {
    return this.http.get<CategoryBean>(`http://127.0.0.1:8081/Provider/findCategoryById?id=` + id)
  }




  addDeliveryArea(deliveryArea) {
    return this.http.post<DeliveryAreaBean>(`http://127.0.0.1:8081/Provider/addDeliveryArea`, deliveryArea)
  }

  addProvider(provider) {
    return this.http.post<ProviderBean>(`http://127.0.0.1:8081/Provider/addProvider`, provider)
  }

  addProviderUser(providerUser) {
    return this.http.post<providerUsersBean>(`http://127.0.0.1:8081/Provider/addProviderUser`, providerUser)
  }

  addBranch(branch) {
    return this.http.post<BranchBean>(`http://127.0.0.1:8081/Provider/addBranch`, branch)
  }

  addCategory(category) {
    return this.http.post<CategoryBean>(`http://127.0.0.1:8081/Provider/addCategory`, category)
  }



  updateBranch(branch) {
    return this.http.put<BranchBean>(`http://127.0.0.1:8081/Provider/updateBranch`, branch)
  }

  updateDeliveryArea(deliveryArea) {
    return this.http.put<DeliveryAreaBean>(`http://127.0.0.1:8081/Provider/updateDeliveryArea`, deliveryArea)
  }

  updateProvider(provider) {
    return this.http.put<ProviderBean>(`http://127.0.0.1:8081/Provider/updateProvider`, provider)
  }

  updateProviderUser(providerUser) {
    return this.http.put<providerUsersBean>(`http://127.0.0.1:8081/Provider/updateProviderUser`, providerUser)
  }

  updateCategory(category) {
    return this.http.put<CategoryBean>(`http://127.0.0.1:8081/Provider/updateCategory`, category)
  }



  removeBranch(id) {
    return this.http.delete(`http://127.0.0.1:8081/Provider/removeBranch?id=` + id);
  }

  removeCategory(id) {
    return this.http.delete(`http://127.0.0.1:8081/Provider/removeCategory?id=` + id);
  }

  removeProvider(id) {
    return this.http.delete(`http://127.0.0.1:8081/Provider/removeProvider?id=` + id)
  }

  removeProviderUser(id) {
    return this.http.get<providerUsersBean[]>(`http://127.0.0.1:8081/Provider/removeProviderUser?id=` + id)
  }

  removeDeliveryArea(id) {
    return this.http.delete(`http://127.0.0.1:8081/Provider/removeDeliveryArea?id=` + id)
  }
}
