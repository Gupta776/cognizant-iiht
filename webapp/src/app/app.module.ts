import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './page-view/header/header.component';
import { FooterComponent } from './page-view/footer/footer.component';
import { LoginComponent } from './page-view/login/login.component';
import { SignupComponent } from './page-view/signup/signup.component';
import { DatePipe } from '@angular/common';
// import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './page-view/home/home.component';
import { ExcelUploadComponent } from './excel/excel-upload/excel-upload.component';
import { SummaryComponent } from './excel/summary/summary.component';
import { ProfileUpdateComponent } from './user/profile-update/profile-update.component';
import { AdminHomeComponent } from './admin/admin-home/admin-home.component';
import { SearchCompanyComponent } from './company/search-company/search-company.component';
import { CompanyComponent } from './company/company/company.component';
import { CompanyDetailsComponent } from './company/company-details/company-details.component';
import { ChartComponent } from './user/chart/chart.component';
import { ChartCompareComponent } from './user/chart-compare/chart-compare.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    SignupComponent,
    HomeComponent,
    ExcelUploadComponent,
    SummaryComponent,
    ProfileUpdateComponent,
    AdminHomeComponent,
    SearchCompanyComponent,
    CompanyComponent,
    CompanyDetailsComponent,
    ChartComponent,
    ChartCompareComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    // BsDatepickerModule.forRoot(),
    BrowserAnimationsModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
