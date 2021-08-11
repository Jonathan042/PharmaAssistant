import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css'],
  entryComponents: [ErrorComponent]
})
export class ErrorComponent implements OnInit {

  constructor() {}

  ngOnInit(): void {
  }

}
