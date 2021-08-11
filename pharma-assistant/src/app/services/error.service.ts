import { ErrorHandler, Injectable, Injector } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ErrorService implements ErrorHandler{

  private router: Router;


  constructor(injector: Injector) {
    setTimeout(() => this.router = injector.get(this.router));
   }

   handleError(error){
      this.router.navigate(['/error']);
   }
   
}
