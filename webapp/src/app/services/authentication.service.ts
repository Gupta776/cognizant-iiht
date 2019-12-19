import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  loggedIn: boolean = false;
  user: string;
  constructor() { }
  currentUser() {
    return this.user;
  }

  login(userLoggedIn) {
    this.user = userLoggedIn;
    this.loggedIn = true;
  }

  logout() {
    this.user = null;
    this.loggedIn = false;
  }

  isLoggedIn() {
    return this.loggedIn;
  }
}
