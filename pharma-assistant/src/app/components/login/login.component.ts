import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { LoginService } from 'src/app/services/login.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';

  constructor(private fb:FormBuilder,private ls:LoginService,private tokenStorage: TokenStorageService,private router:Router) {
    this.form = this.fb.group({
      username: ['',Validators.required],
      password: ['',Validators.required]
    });
   }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
    }
  }

  onSubmit(){
    const val:User = this.form.value;
    this.ls.login(val).subscribe(
      data => {
        this.tokenStorage.saveToken(data.token);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.router.navigateByUrl("/batches");
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }
  
  reloadPage(): void {
    window.location.reload();
  }

}
