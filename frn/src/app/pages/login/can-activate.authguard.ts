import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from "@angular/router";
import {Injectable} from "@angular/core";
import {LoginService} from "./login.service";
@Injectable()


export class CanActivateAuthGuard implements CanActivate {

  constructor(private router: Router, private loginService: LoginService){}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    console.log('czy zalogowany? '+this.loginService.isLoggedIn());
    if (this.loginService.isLoggedIn()) {
      // logged in so return true
      return true;
    }

    // not logged in so redirect to login page with the return url and return false
    this.router.navigate(['auth/login']);
    return false;
  }


  }

