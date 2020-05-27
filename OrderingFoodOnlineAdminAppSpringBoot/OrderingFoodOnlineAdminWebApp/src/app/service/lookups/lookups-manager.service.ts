import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CityBean, AreaBean } from 'src/app/lookups/LookupsBeans';

@Injectable({
  providedIn: 'root'
})
export class LookupsManagerService {

  constructor(
    private http: HttpClient
  ) { }

  findCityList() {
    let headers = this.getHttpHeaders();
    return this.http.get<CityBean[]>('https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/findCityList')
  }
  findAreaList() {
    let headers = this.getHttpHeaders();
    return this.http.get<AreaBean[]>('https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/findAreaList')
  }

  findAreaListByCityId(id) {
    let headers = this.getHttpHeaders();
    return this.http.get<AreaBean[]>('https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/findAreaListByCityId?id=' + id)
  }
  removeCityById(id) {
    let headers = this.getHttpHeaders();
    return this.http.delete(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/removeCity?id=` + id)
  }

  removeAreaById(id) {
    let headers = this.getHttpHeaders();
    return this.http.delete(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/removeArea?id=` + id)
  }

  findCityById(id) {
    let headers = this.getHttpHeaders();
    return this.http.get<CityBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/findCityById?id=` + id)
  }

  findAreaById(id) {
    let headers = this.getHttpHeaders();
    return this.http.get<AreaBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/findAreaById?id=` + id)
  }

  addNewCity(city) {
    let headers = this.getHttpHeaders();
    return this.http.post<CityBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/addCity`, city)
  }

  updateCity(city) {
    let headers = this.getHttpHeaders();
    return this.http.put<CityBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/updateCity`, city)
  }


  addNewArea(area) {
    let headers = this.getHttpHeaders();
    return this.http.post<AreaBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/addArea`, area)
  }

  updateArea(area) {
    let headers = this.getHttpHeaders();
    return this.http.put<AreaBean>(`https://orderingfoodonlineadminwebapp-busy-okapi-dk.cfapps.io/Lookups/updateArea`, area)
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
