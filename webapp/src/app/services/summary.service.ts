import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SummaryService {

  constructor(private httpClient:HttpClient) { }

  showSummary(){ 
    // let apiEndPoint = "http://localhost:8201/stock-market-charting/summary";
    let apiEndPoint = "http://localhost:8210/excel-uploading-service/stock-market-charting/summary";
    return this.httpClient.get(apiEndPoint);
  }
}
