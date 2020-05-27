import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { LogoutComponent } from './logout/logout.component';
import { CityListComponent } from './lookups/city-list/city-list.component';
import { UpdateCityComponent } from './lookups/update-city/update-city.component';
import { AddCityComponent } from './lookups/add-city/add-city.component';
import { ErrorComponent } from './error/error.component';
import { ProviderListComponent } from './providers/provider-list/provider-list.component';
import { UpdateProviderComponent } from './providers/update-provider/update-provider.component';
import { AddProviderComponent } from './providers/add-provider/add-provider.component';
import { BranchListComponent } from './providers/branch-list/branch-list.component';
import { AreaListComponent } from './lookups/area-list/area-list.component';
import { AddAreaComponent } from './lookups/add-area/add-area.component';
import { UpdateAreaComponent } from './lookups/update-area/update-area.component';
import { CategoryBean } from './providers/ProviderBeans';
import { CategoryListComponent } from './providers/category-list/category-list.component';
import { ProviderUserListComponent } from './providers/provider-user-list/provider-user-list.component';
import { AddBranchComponent } from './providers/add-branch/add-branch.component';
import { UpdateBranchComponent } from './providers/update-branch/update-branch.component';


const routes: Routes = [
  { path: "", component: LoginComponent },
  { path: "login", component: LoginComponent },
  { path: "home/:name", component: HomeComponent },
  { path: "cityList", component: CityListComponent },
  { path: "areaList/:id", component: AreaListComponent },
  { path: "update-city/:id", component: UpdateCityComponent },
  { path: "new-city", component: AddCityComponent },
  { path: "new-area/:id", component: AddAreaComponent },
  { path: "update-area/:cityId/:areaId", component: UpdateAreaComponent },
  { path: "providerList", component: ProviderListComponent },
  { path: "update-provider/:providerId", component: UpdateProviderComponent },
  { path: "new-provider", component: AddProviderComponent },
  { path: "new-branch/:providerId", component: AddBranchComponent },
  { path: "branchList/:providerId", component: BranchListComponent },
  { path: "update-branch/:branchId", component: UpdateBranchComponent },
  { path: "categoryList/:providerId", component: CategoryListComponent },
  { path: "providerUserList/:providerId", component: ProviderUserListComponent },
  { path: "logout", component: LogoutComponent },
  { path: "**", component: ErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
