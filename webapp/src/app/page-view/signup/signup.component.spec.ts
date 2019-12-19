import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SignupComponent } from './signup.component';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';

import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

fdescribe('SignupComponent', () => {
  let component: SignupComponent;
  let fixture: ComponentFixture<SignupComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [SignupComponent],
      imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule,FormsModule, HttpClientModule, RouterModule.forRoot([])]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SignupComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('form invalid when empty', () => {
    expect(component.signupForm.valid).toBeFalsy();
  });

  it('component variables to be initilized', () => {
    expect(component.existFlag).toBeFalsy();
    expect(component.signupForm.value.userName).toBeNull();
    expect(component.signupForm.value.password).toBeNull();
    expect(component.signupForm.value.confirmPassword).toBeNull();
    expect(component.signupForm.value.email).toBeNull();
    expect(component.signupForm.value.contactNumber).toBeNull();
  });

  it('created a form with username,contactnumber,email and password with signup button', () => {
    const userNameContainer = fixture.debugElement.nativeElement.querySelector('#userName');
    const passwordContainer = fixture.debugElement.nativeElement.querySelector('#password');
    const contactContainer = fixture.debugElement.nativeElement.querySelector('#contactnumber');
    const emailContainer = fixture.debugElement.nativeElement.querySelector('#email');

    expect(userNameContainer).toBeDefined();
    expect(passwordContainer).toBeDefined();
    expect(contactContainer).toBeDefined();
    expect(emailContainer).toBeDefined();
  });

 


});