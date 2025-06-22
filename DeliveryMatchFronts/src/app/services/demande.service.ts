import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DemandeService {


  private Url= "http://localhost:8086/demande";
  constructor(private http:HttpClient) { }

  AddDemande(post:any):Observable<any>{
    return this.http.post(`${this.Url}`,post)
  }

  lisDemande():Observable<any>{
    return this.http.get(this.Url)
  }
  deleteDemande(id:number):Observable<any>{
    return this.http.delete(`${this.Url}/${id}`)
  }
  updateDemande(editdata:any,id:number):Observable<any>{
    return this.http.put(`${this.Url}/${id}`,editdata)
  }
  AfficherDemmandeByid(id:any) : Observable<any> {
    return this.http.get(`${this.Url}/${id}`);
  }
}
