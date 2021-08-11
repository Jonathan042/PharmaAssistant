import { ErrorHandler, Injectable, Injector } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ErrorService implements ErrorHandler{

  constructor(injector: Injector,private router: Router) {
   }

   handleError(error){
      console.log(error);
      this.router.navigateByUrl('/error');
   }
   
}
