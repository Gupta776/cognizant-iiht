import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserAuthenticationService } from 'src/app/services/user-authentication.service';

@Component({
  selector: 'app-profile-update',
  templateUrl: './profile-update.component.html',
  styleUrls: ['./profile-update.component.css']
})
export class ProfileUpdateComponent implements OnInit {

  user:any;
  constructor(private userService:UserService,private authService:AuthenticationService,
    private userAuthService: UserAuthenticationService) { }
  checkpass:boolean=false;
 signupForm:any;
 updateSuccess:boolean=false;
  ngOnInit() {

    this.user = {
      username: "",
      contactNo: "",
      email: "",
      password: "",
      confirmPassword: "",
      confirmation:false
    }
    

    this.signupForm = new FormGroup({
      userName: new FormControl({value:'',disabled:true}),
      password: new FormControl('', [Validators.required, Validators.minLength(2), Validators.maxLength(15)]),
      confirmPassword: new FormControl('', [Validators.required]),
      contactNumber: new FormControl('', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
      email: new FormControl({value:'',disabled:true}),
    });

    this.userService.getUser(this.userAuthService.getUserName()).subscribe((response)=>{this.user=response;
    this.signupForm.setValue({
      userName:this.user.userName,
      password:"",
      confirmPassword:"",
      email:this.user.email,
      contactNumber:this.user.contactNumber
    })})

  }

  checkIfMatchingPasswords() {
    if (this.signupForm.value.password == this.signupForm.value.confirmPassword) {
      this.checkpass = true;
    } else {
      this.checkpass = false;
    }
  }
  updateUser(signupForm){
  
    this.user.password = signupForm.value.password;
    this.user.confirmPassword = signupForm.value.confirmPassword;
    this.user.contactNumber = signupForm.value.contactNumber;
    this.userService.updateUser(this.user).subscribe((response)=>{this.updateSuccess=true;});
  }

}
