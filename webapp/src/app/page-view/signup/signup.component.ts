import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { user } from 'src/app/model/user';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  signupForm: FormGroup;
  user:user[];
  newUser:user;
  passwordFlag: boolean;
  newUserFlag: boolean =  false;
  existFlag:boolean = false;
  constructor(private userService:UserService) { }

  ngOnInit() {
    this.existFlag = false;
    this.signupForm = new FormGroup(
      {
        'userName': new FormControl(null, [Validators.required,Validators.maxLength(15),Validators.minLength(2)]),
        'password': new FormControl(null, [Validators.required]),
        'confirmPassword': new FormControl(null, [Validators.required]),
        'email': new FormControl(null, [Validators.required]),
        'contactNumber': new FormControl(null, [Validators.required, Validators.maxLength(10), Validators.minLength(10), Validators.pattern("^[0-9]*$")]),
        // 'confirmed' : new FormControl(null, [Validators.required])
      });
  }

  onSubmit(){
    console.log(this.signupForm.value);
    this.newUser = {
      userName: this.signupForm.value.userName,
      password: this.signupForm.value.password,
      email : this.signupForm.value.email,
      contactNumber: this.signupForm.value.contactNumber,
      confirmed : false
    };
    this.userService.signupUser(this.newUser).subscribe((response)=>{
      this.newUserFlag = true;
     },(error)=>{
       this.existFlag = true;
     });
  }
  passwordMatch() {
    if (this.signupForm.value.password == this.signupForm.value.confirmPassword) {
      this.passwordFlag = true;
    } else {
      this.passwordFlag = false;
    }
  }

}
