import { BrowserModule } from '@angular/platform-browser';
import { DataTablesModule } from 'angular-datatables';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgSelectModule } from '@ng-select/ng-select';



import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MenuComponent } from './menu/menu.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { CityListComponent } from './lookups/city-list/city-list.component';
import { AddCityComponent } from './lookups/add-city/add-city.component';
import { UpdateCityComponent } from './lookups/update-city/update-city.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ErrorComponent } from './error/error.component';
import { UpdateAreaComponent } from './lookups/update-area/update-area.component';
import { AddAreaComponent } from './lookups/add-area/add-area.component';
import { AreaListComponent } from './lookups/area-list/area-list.component';
import { ProviderListComponent } from './providers/provider-list/provider-list.component';
import { AddProviderComponent } from './providers/add-provider/add-provider.component';
import { UpdateProviderComponent } from './providers/update-provider/update-provider.component';
import { UpdateBranchComponent } from './providers/update-branch/update-branch.component';
import { AddBranchComponent } from './providers/add-branch/add-branch.component';
import { BranchListComponent } from './providers/branch-list/branch-list.component';
import { CategoryListComponent } from './providers/category-list/category-list.component';
import { ProviderUserListComponent } from './providers/provider-user-list/provider-user-list.component';
import { DeliveryAreaListComponent } from './providers/delivery-area-list/delivery-area-list.component';
import { AddDeliveryAreaComponent } from './providers/add-delivery-area/add-delivery-area.component';
import { UpdateDeliveryAreaComponent } from './providers/update-delivery-area/update-delivery-area.component';
import { UpdateCategoryComponent } from './providers/update-category/update-category.component';
import { UpdateProviderUserComponent } from './providers/update-provider-user/update-provider-user.component';
import { AddProviderUserComponent } from './providers/add-provider-user/add-provider-user.component';
import { AddCategoryComponent } from './providers/add-category/add-category.component';

@NgModule({
  declarations: [
    AppComponent,
    MenuComponent,
    FooterComponent,
    HomeComponent,
    CityListComponent,
    AddCityComponent,
    UpdateCityComponent,
    LoginComponent,
    LogoutComponent,
    ErrorComponent,
    UpdateAreaComponent,
    AddAreaComponent,
    AreaListComponent,
    ProviderListComponent,
    AddProviderComponent,
    UpdateProviderComponent,
    UpdateBranchComponent,
    AddBranchComponent,
    BranchListComponent,
    CategoryListComponent,
    ProviderUserListComponent,
    DeliveryAreaListComponent,
    AddDeliveryAreaComponent,
    UpdateDeliveryAreaComponent,
    UpdateCategoryComponent,
    UpdateProviderUserComponent,
    AddProviderUserComponent,
    AddCategoryComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    NgSelectModule,
    HttpClientModule,
    AppRoutingModule,
    DataTablesModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
