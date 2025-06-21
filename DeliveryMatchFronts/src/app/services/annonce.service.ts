import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {pseudoRandomBytes} from 'node:crypto';

@Injectable({
  providedIn: 'root'
})
export class AnnonceService {
  private url = "http://localhost:8087/Annonces"


  constructor(private http:HttpClient) { }



  ListAnnonce():Observable<any> {
    return this.http.get<any>(this.url);
  }
  AddAnnonce(post:any):Observable<any>{
    return this.http.post(`${this.url}`,post)
  }
  EditAnnocne(edittData : any,id:number):Observable<any>{
    return this.http.put(`${this.url}/${id}`,edittData)
  }
  SupprimerAnnonce(id:number):Observable<any>{
    return this.http.delete(`${this.url}/${id}`)
  }
}
