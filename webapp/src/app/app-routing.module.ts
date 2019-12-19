import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './page-view/login/login.component';
import { SignupComponent } from './page-view/signup/signup.component';
import { HomeComponent } from './page-view/home/home.component';
import { ExcelUploadComponent } from './excel/excel-upload/excel-upload.component';
import { AuthenticationGuard } from './gaurd/authentication.guard';
import { CompanyComponent } from './company/company/company.component';
import { ChartComponent } from './user/chart/chart.component';
import { ProfileUpdateComponent } from './user/profile-update/profile-update.component';
import { ChartCompareComponent } from './user/chart-compare/chart-compare.component';


const routes: Routes = [
  // {path:"",component:HomeComponent},
  {path:"",component:LoginComponent},
  {path:"home",component:HomeComponent},
  {path:"company-main-page",component:CompanyComponent},
  {path:"charts/:code",component:ChartComponent},
  {path:"excel-upload",component:ExcelUploadComponent, canActivate:[AuthenticationGuard]},
  {path:"login",component:LoginComponent},
  {path:"signup",component:SignupComponent},
  {path:"profile-update",component: ProfileUpdateComponent, canActivate:[AuthenticationGuard]},
  {path:"compare-charts",component:ChartCompareComponent, canActivate:[AuthenticationGuard]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
