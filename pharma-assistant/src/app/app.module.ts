import { Component, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { Routes, RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AddBatchComponent } from './components/add-batch/add-batch.component';
import { LinkComponent } from './components/link/link.component';

const routes: Routes=[
  { path: 'login', component: LoginComponent},
  { path: 'batches', component: LinkComponent},
  { path: 'batches/add', component: AddBatchComponent},
  { path: '**',redirectTo: '/login',pathMatch:'full'}
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddBatchComponent,
    LinkComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(routes),
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
