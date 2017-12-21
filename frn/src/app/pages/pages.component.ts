import { Component } from '@angular/core';



@Component({
  selector: 'app-pages',
  templateUrl: './pages.component.html',
  styleUrls: ['/vendor/bootstrap/css/bootstrap.min.css',
    '/css/small-business.css']

})
export class PagesComponent {

  loggedUser: any;

  constructor(){
    this.loggedUser = localStorage.getItem('currentUser') ?
      JSON.parse(localStorage.getItem('currentUser')).username :
      'none user logged in';
    console.log("loggedUserPages", this.loggedUser);
  }


}
