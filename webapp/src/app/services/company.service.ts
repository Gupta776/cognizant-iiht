import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserAuthenticationService } from './user-authentication.service';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class CompanyService {
  getStockDetails(companyCode: string) {
    throw new Error("Method not implemented.");
  }
  baseUrl = environment.baseUrl;
  constructor(private httpClient:HttpClient, 
    private userAuthService:UserAuthenticationService) { }

  getAllCompanies(){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOptions = {
      headers : new HttpHeaders ({
        'Content-Type' : 'application/json',
        'Authorization' : token
      })
    };
    return this.httpClient.get(this.baseUrl+"/company-service/stock-market-charting/company/all-companies",httpOptions);
  
  }
  getStockLatest(code){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+"/company-service/stock-market-charting/stock-price/latest/"+code , httpOption);
  }
  getStockPrice(code){
    let token = "Bearer "+ this.userAuthService.getToken();
    const httpOption = { headers : new HttpHeaders({'Content-Type' : 'application/json', 'Authorization': token})};
    return this.httpClient.get<any>(this.baseUrl+"/company-service/stock-market-charting/stock-price/"+code , httpOption);
  }

}
