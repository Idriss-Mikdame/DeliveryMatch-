import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable, tap} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterLoginService {
    private url="http://localhost:8086/api/v1/auth"
    private url1 = "http://localhost:8086/api/v1/auth"
     private tokenKey = 'auth_token';

  constructor(private http:HttpClient) { }


  Login(postlogin:any):Observable<any>{
    return this.http.post(`${this.url1}/authenticate`, postlogin).pipe(
      tap((res: any) => {
        if (res.token) {
          localStorage.setItem(this.tokenKey, res.token);
        }
      })
    );
  }
  RegisterUser(poste:any) : Observable<any> {
    return this.http.post(`${this.url}/register`, poste);
  }
  // Sauvegarde token
  private setAuthData(token: string): void {
    localStorage.setItem(this.tokenKey, token);
  }

  // Récupérer le token
  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  logout(): void {
    localStorage.removeItem(this.tokenKey);
  }



}
