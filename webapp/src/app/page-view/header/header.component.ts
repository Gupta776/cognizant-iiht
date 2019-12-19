import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserAuthenticationService } from 'src/app/services/user-authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private authService: AuthenticationService,
    private userAuthService : UserAuthenticationService
    ) { }

  ngOnInit() {
  }
  logout() {
    this.userAuthService.setToken(null);
    this.userAuthService.setRole(null);
    this.userAuthService.setUserName(null);
    this.userAuthService.setConfirmed(null);
    this.authService.logout();

  }
  user: string;
  getName() {
    return this.authService.currentUser();

  }
  getConfirmed(){
    return this.userAuthService.getConfirmed();
  }
  getRole(){
    return this.userAuthService.getRole();
  }

}
