import { Component, OnInit } from '@angular/core';
import {RegisterService} from "./register.service";
import {User} from "../../utils/models/user";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['../vendor/bootstrap/css/bootstrap.min.css',
    '../css/small-business.css',
    './register.component.css']
})
export class RegisterComponent implements OnInit {

  userForm = new FormGroup({
    name: new FormControl('', Validators.required),
    surname: new FormControl('', Validators.required),
    email: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
    confirmpassword: new FormControl('', Validators.required),
    date:  new FormControl('', Validators.required),
    username: new FormControl('', Validators.required)
  });
  errors: string[];

  constructor(private registerService: RegisterService) {
  }

  ngOnInit() {
  }

  createUser() {
    let name = this.userForm.get('name').value.trim();
    let surname = this.userForm.get('surname').value.trim();
    let email = this.userForm.get('email').value.trim();
    let password = this.userForm.get('password').value.trim();
    let confirmpassword = this.userForm.get('confirmpassword').value.trim();
    let username = this.userForm.get('username').value.trim();
    let date = this.userForm.get('date').value.trim();
    console.log("dane:", name, surname, email, password, confirmpassword, username);
    if(password != confirmpassword){
      console.log("dziala");

    }
    let user = new User(null, username, name, surname, email, password, date, true);
    this.registerService.createUser(user)
      .subscribe(successCode => {
        this.errors = successCode;
        console.log("errorCode", this.errors);

      })
    // errorCode => this.statusCode = errorCode);
  }


}
