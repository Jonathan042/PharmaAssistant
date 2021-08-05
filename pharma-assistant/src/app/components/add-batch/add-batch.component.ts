import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-batch',
  templateUrl: './add-batch.component.html',
  styleUrls: ['./add-batch.component.css']
})
export class AddBatchComponent implements OnInit {

  batchForm = new FormGroup({
    batch_code : new FormControl(),
    weight : new FormControl(),
    price : new FormControl(),
    refrigeration : new FormControl(),
    medicine : new FormGroup({
      medicine_type : new FormControl(Validators.required)
    })
  })


  constructor() { }

  ngOnInit(): void {
  }

}
