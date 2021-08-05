import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
import { Batch } from '../models/batch';

@Injectable({
  providedIn: 'root'
})
export class BatchService {
  private baseurl = "http://localhost:5000/api/batches"
  httpOptions={
    headers: new HttpHeaders({
      'Authorization':'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwYXRzdW1zIiwiZXhwIjoxNjI4MjAwOTM0LCJpYXQiOjE2MjgxODI5MzR9.4eUaJPerosu1PIgONaR_ne0D0F4PHJJAVns4g4Mu0UPeZQTOrCxLbaRFsvX5SsLWzrI63KFKS0-wufpFR5j7qA',
      'Content-Type':'application/json'
    })
  }
  
  constructor(private httpc:HttpClient) { }

  addBatch(batch:Batch){
    console.log(batch);
    return this.httpc.post(this.baseurl,batch,this.httpOptions);
  }
}
