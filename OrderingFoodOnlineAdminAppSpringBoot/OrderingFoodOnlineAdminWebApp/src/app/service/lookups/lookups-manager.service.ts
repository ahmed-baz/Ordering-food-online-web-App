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
    return this.http.get<CityBean[]>('http://127.0.0.1:8081/Lookups/findCityList')
  }

  findAreaList() {
    return this.http.get<AreaBean[]>('http://127.0.0.1:8081/Lookups/findAreaList')
  }

  findAreaListByCityId(id) {
    return this.http.get<AreaBean[]>('http://127.0.0.1:8081/Lookups/findAreaListByCityId?id=' + id)
  }

  findCityById(id) {
    return this.http.get<CityBean>(`http://127.0.0.1:8081/Lookups/findCityById?id=` + id)
  }

  findCityWithDetailsById(id) {
    return this.http.get<CityBean>(`http://127.0.0.1:8081/Lookups/findCityWithDetailsById?id=` + id)
  }

  findAreaById(id) {
    return this.http.get<AreaBean>(`http://127.0.0.1:8081/Lookups/findAreaById?id=` + id)
  }

  findAreaWithDetailsById(id) {
    return this.http.get<AreaBean>(`http://127.0.0.1:8081/Lookups/findAreaWithDetailsById?id=` + id)
  }



  addNewCity(city) {
    
    return this.http.post<CityBean>(`http://127.0.0.1:8081/Lookups/addCity`, city)
  }

  addNewArea(area) {
    
    return this.http.post<AreaBean>(`http://127.0.0.1:8081/Lookups/addArea`, area)
  }


  updateCity(city) {
    
    return this.http.put<CityBean>(`http://127.0.0.1:8081/Lookups/updateCity`, city)
  }

  updateArea(area) { 
    return this.http.put<AreaBean>(`http://127.0.0.1:8081/Lookups/updateArea`, area)
  }


  removeCityById(id) {
    return this.http.delete(`http://127.0.0.1:8081/Lookups/removeCity?id=` + id)
  }

  removeAreaById(id) {
    return this.http.delete(`http://127.0.0.1:8081/Lookups/removeArea?id=` + id)
  }

}
