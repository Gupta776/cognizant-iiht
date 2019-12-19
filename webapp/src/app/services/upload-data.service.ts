import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { UserAuthenticationService } from './user-authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UploadDataService {

  // baseUrl:string;
  // constructor(private httpClient:HttpClient,
  //   private userAuthService:UserAuthenticationService) {
  //   this.baseUrl =environment.baseUrl;
  //  }
  // uploadFile(formData){
  //   let token = "Bearer " + this.userAuthService.getToken();
  //     return this.httpClient.post(this.baseUrl+"/excel-uploading-service/stock-market-charting/upload-stock-data",formData);
  // }
  // getSummary(){
  //   let token = "Bearer " + this.userAuthService.getToken();
  //   const httpOption = {
  //     headers: new HttpHeaders({
  //       'content-type': 'application/json',
  //       'Authorization': token
  //     })
  //   };
  //   return this.httpClient.get(this.baseUrl+"/excel-uploading-service/stock-market-charting/summary",httpOption);
  // }

  // getStockDetails(companyCode){
  //   let token = "Bearer " + this.userAuthService.getToken();
  //   const httpOption = {
  //     headers: new HttpHeaders({
  //       'content-type': 'application/json',
  //       'Authorization': token
  //     })
  //   };
  //   return this.httpClient.get(this.baseUrl+"/excel-uploading-service/stock-market-charting/stock-details/"+companyCode,httpOption);
  // }
}
