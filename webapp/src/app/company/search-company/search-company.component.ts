import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-company',
  templateUrl: './search-company.component.html',
  styleUrls: ['./search-company.component.css']
})
export class SearchCompanyComponent implements OnInit {
  @Output() companySearchList: any;
  searchData : String;
  constructor() { 
    this.companySearchList = new EventEmitter;
  }

  ngOnInit() {
  }
  
}
