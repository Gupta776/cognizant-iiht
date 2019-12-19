import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { UserAuthenticationService } from './user-authentication.service';
import { user } from '../model/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
baseUrl = environment.baseUrl;
  constructor(private httpClient:HttpClient,
    private userAuthService :UserAuthenticationService) { }
    user = new Array<user>();

  signupUser(newUser: user){
    console.log(newUser);
    return this.httpClient.post<any>(this.baseUrl+"/authentication-service/stock-market-charting/users",newUser);
  }

  getUser(userName:String){
    // let url = environment.baseUrl + "/authentication-service/stock-market-charting/users/get-user/" + userName;
    let token = 'Bearer ' + this.userAuthService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.get(this.baseUrl+"/authentication-service/stock-market-charting/users/get-user/"+userName,httpOptions);
  }
  updateUser(user:user){
    
    let url = environment.baseUrl + "/authentication-service/stock-market-charting/users/update-user"
    let token = 'Bearer ' + this.userAuthService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'content-type': 'application/json',
        'Authorization': token
      })
    };
    return this.httpClient.put(url,user,httpOptions);
  }
  
}
