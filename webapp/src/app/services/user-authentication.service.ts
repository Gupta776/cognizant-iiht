import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationService {
  private authenticationUrl = "http://localhost:8210/authentication-service/stock-market-charting/authentication";
  private token: String;
  private userName :String;
  private role:String;
  private confirmed: String;
  constructor(private httpClient: HttpClient) { }

  authenticate(user: String, password: String): Observable<any> {
    let credentials = btoa(user + ":" + password);
    let headers = new HttpHeaders();
    headers = headers.set("Authorization", "Basic " + credentials);
    return this.httpClient.get(this.authenticationUrl, {headers});
  }
  public setToken(token: String) {
    this.token = token;
  }
  public getToken() {
    return this.token;
  }
  public setUserName(userName:String){
    this.userName=userName;
  }
  public getUserName() {
    return this.userName;
  }
  public setRole(role:String){
    this.role = role;
  }
  public getRole(){
    return this.role;
  }
  public setConfirmed(confirmed : String){
    this.confirmed = confirmed;
  }
  public getConfirmed(){
    return this.confirmed;
  }
}
