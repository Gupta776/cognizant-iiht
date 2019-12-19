import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { UserAuthenticationService } from 'src/app/services/user-authentication.service';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  errorFlag: boolean = false;
  userFlag:boolean = false;
  loginFlag:boolean =false;
  pendingFlag:boolean= false;
  error : any;
  constructor(private router: Router,
    private routerActive:ActivatedRoute,
    private userAuthService: UserAuthenticationService,
    private authService: AuthenticationService) {
  }
  ngOnInit() {
    
    this.errorFlag = false;
    this.userFlag = false;
    this.loginFlag =false;
    this.loginForm = new FormGroup({
           'userName': new FormControl(null, [Validators.required,
           ]),
           'password': new FormControl(null, [Validators.required])
         });
  }
  goToForgotUserID(){
    // this.router.navigate(['/forgotPassword','id']);
  }

  goToForgotPassword(){
    // this.router.navigate(['/forgotPassword','password']);
  }
  onSubmit(){
    this.pendingFlag = false;
    console.log(this.loginForm.value);
    this.userAuthService.authenticate(this.loginForm.value.userName,
                                      this.loginForm.value.password)
    .subscribe((response)=>{
      // if(response.status == 'P'){
      //   this.userAuthService.setToken(null);
      //   this.userAuthService.setUserName(null);
      // }else{
        console.log(response.confirmed);
      if(response.confirmed == "true"){
        console.log("inside the service");
        console.log(response);
        this.loginFlag = true;
        this.userAuthService.setToken(response.token);
        this.userAuthService.setUserName(response.userName);
        this.userAuthService.setRole(response.role);
        this.userAuthService.setConfirmed(response.confirmed);
        this.authService.login(this.loginForm.value.userName);//just ask ramesh wheather we need to use the authservice
       
        console.log(this.userAuthService.getConfirmed());
        console.log("home to navigate");
        this.router.navigate(["/company-main-page"]);
        // if(response.role == 'user'){
        //   this.router.navigate(["/home"]);
        // }else{
        //   this.router.navigate(["/excel-upload"]);
        // }
        
      }else{
        console.log("false is occured");
        this.pendingFlag = true;
      }
      
      // }
    },(error)=>{
      this.error = "invalid username/ password";
      this.errorFlag = true;
    });
  }
  // getStatus(){
  //   return this.userAuthService.getStatus();
  // }
}
