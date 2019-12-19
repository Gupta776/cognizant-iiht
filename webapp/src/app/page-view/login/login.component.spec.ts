import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LoginComponent } from './login.component';

import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { RouterTestingModule } from '@angular/router/testing';

import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { By } from '@angular/platform-browser';
fdescribe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [ReactiveFormsModule, HttpClientTestingModule, RouterTestingModule,FormsModule, HttpClientModule, RouterModule.forRoot([])]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('form invalid when empty', () => {
    expect(component.loginForm.valid).toBeFalsy();
  });
  it('component variables to be initilized', () => {
    expect(component.errorFlag).toBeFalsy();
    expect(component.loginForm.value.userName).toBeNull();
    expect(component.loginForm.value.password).toBeNull();
  });

  it('created a form with username and password with login button', () => {
    const userNameContainer = fixture.debugElement.nativeElement.querySelector('#userName');
    const passwordContainer = fixture.debugElement.nativeElement.querySelector('#password');

    expect(userNameContainer).toBeDefined();
    expect(passwordContainer).toBeDefined();
  });

});
