import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators'
import { Batch } from '../models/batch';

@Injectable({
  providedIn: 'root'
})
export class BatchService {
  private baseurl = "http://localhost:5000/rest/batches"
  httpOptions={
    headers: new HttpHeaders({
      'Content-Type':'application/json'
    })
  }
  
  constructor(private httpc:HttpClient) { }

  addBatch(batch:Batch){
   // this.getBatch();
    return this.httpc.post(this.baseurl,batch,this.httpOptions);
  }

  getBatch(){
    return this.httpc.get<GetResponse>(this.baseurl).pipe(map(result=>result._embedded.batches));
  }
}

interface GetResponse{
  _embedded: {
    batches: Batch[];
  }, 
}
