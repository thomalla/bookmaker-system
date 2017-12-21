//noinspection TypeScriptCheckImport
import {Headers, Http, RequestOptions} from "@angular//http";
import {User} from "../../utils/models/user";
import {Observable} from "rxjs/Rx";
import {Injectable} from "@angular/core";

@Injectable()
export class RegisterService {

  // allArticlesUrl = "http://localhost:8080/user/all-articles";
  userUrl = "api/auth/addUser";

  //Create constructor to get Http instance
  constructor(private http:Http) {}

  createUser(user: User): Observable<string[]>{
    let cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    let options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.userUrl, user, options)
      .map(success => success.json())
      .catch(this.handleError);
  }

  private handleError (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.status);
  }


}
