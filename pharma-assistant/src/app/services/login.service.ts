import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private baseurl = "http://localhost:5000/auth/login"
  httpOptions={
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  }


  constructor(private httpc:HttpClient) { }

  login(user:User) : Observable<string>{
    return this.httpc.post<TokenResponse>(this.baseurl,user,this.httpOptions).pipe(map(response=>response.token));
  }

}

interface TokenResponse{
  token:string
}
