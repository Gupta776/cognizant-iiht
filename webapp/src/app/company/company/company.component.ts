import { Component, OnInit } from '@angular/core';
import { UserAuthenticationService } from 'src/app/services/user-authentication.service';
import { CompanyService } from 'src/app/services/company.service';
import { company } from 'src/app/model/company';
import { Router } from '@angular/router';

@Component({
  selector: 'app-company',
  templateUrl: './company.component.html',
  styleUrls: ['./company.component.css']
})
export class CompanyComponent implements OnInit {
  companyList:any;
  filterCompanyList:any;
  companyDetail :company;
  stockDetailsLatestList: any[];
  searchData:string;
  constructor(private userAuthService:UserAuthenticationService,
    private companyService:CompanyService,
    private router:Router) { }

  ngOnInit() {
    this.getAllCompanies();
  }
  // filterData() {
  //  this.filterCompanyList= this.companySearchList.emit(this.searchData);
  // }
  getAllCompanies(){
    this.companyService.getAllCompanies().subscribe((response)=>{
      console.log(response);
      this.companyList = response;
      this.filterCompanyList = this.companyList;
    },(error)=>{
      console.log("error in get all companies");
    });
  }
  filterData() {
    this.filterCompanyList = this.companyList.filter(
      (item:company) => item.name.toLocaleLowerCase().indexOf(this.searchData) != -1);
  }
  // companyInfo(item:company){
  //   this.companyDetail = item;
  // }

  companyInfo(item:company){
    this.companyList.forEach(company =>{
      if(company.id == item.id){
        this.companyDetail = company;
      }
    });
    this.companyService.getStockLatest(this.companyDetail.companyCode).subscribe(response =>{
      console.log(response);
      this.stockDetailsLatestList = response;
    })
  }
  plot(companyCode){
    this.router.navigate(['charts',companyCode]);
  }
}
