import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  form: FormGroup;

  constructor(private fb:FormBuilder,private ls:LoginService,private router:Router) {
    this.form = this.fb.group({
      username: ['',Validators.required],
      password: ['',Validators.required]
    });
   }

  ngOnInit(): void {
  }

  onSubmit(){
    const val:User = this.form.value;
    if(this.form.valid){
      this.ls.login(val).subscribe(result=>{console.log(result)});
    }
  }

}
