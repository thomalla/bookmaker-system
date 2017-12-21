import {Component, OnInit} from "@angular/core";
import {Router} from "@angular/router";
import {LoginService} from "./login.service";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['../vendor/bootstrap/css/bootstrap.min.css',
    '../css/small-business.css']
})
export class LoginComponent implements OnInit {

  checkUser: string;
  submitted: boolean = false;
  user: any = {};
  errors: string[] = [];

  constructor(private router: Router, private loginService: LoginService) {
    //this.getAllUsers();
    this.checkUser = localStorage.getItem('currentUser') ?
      JSON.parse(localStorage.getItem('currentUser')).username :
      null;
    console.log("loggedUserHome", this.checkUser);

  }

  login() {

    this.submitted = true;
    this.loginService.login(this.user.username, this.user.password)
      .subscribe(result => {
        if(result===true) this.router.navigate(['home']);
        else {
          this.errors.push('Username or password is incorrect');
          this.submitted = false;
        }
        this.checkUser = localStorage.getItem("currentUser");
        console.log("local storage user login", this.checkUser);

      }, error => {
        this.submitted = false;
        this.errors.push(error);
      })
    console.log(this.errors);

  }

  logout()  {
    console.log("jestem w logout component");
    this.checkUser = null;
    this.loginService.logout();

  }

  ngOnInit() {
    // this.loginService.logout();
  }
}
