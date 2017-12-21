import { Component, OnInit } from '@angular/core';
import {RestService} from "../../utils/rest.service";
import {User} from "../../utils/models/user";


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['../vendor/bootstrap/css/bootstrap.min.css',
    '../css/small-business.css']
})
export class HomeComponent implements OnInit {

  loggedUser: any;
  users: User[] = [];
  constructor(private rest: RestService) {
    //this.getAllUsers();
    this.loggedUser = localStorage.getItem('currentUser') ?
      JSON.parse(localStorage.getItem('currentUser')).username :
      null;
    console.log("loggedUserHome", this.loggedUser);
  }

  /*  getAllUsers(){
   this.rest.get('/users/allUsers').subscribe(data=> this.users = data);
   }*/


  ngOnInit() {
  }

}
