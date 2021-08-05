import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Batch } from 'src/app/models/batch';
import { BatchService } from 'src/app/services/batch.service';

@Component({
  selector: 'app-add-batch',
  templateUrl: './add-batch.component.html',
  styleUrls: ['./add-batch.component.css']
})
export class AddBatchComponent implements OnInit {

  batchForm = new FormGroup({
    batchCode : new FormControl(),
    weight : new FormControl(Validators.min(100)),
    price : new FormControl(),
    refrigeration : new FormControl(),
    medicine : new FormControl(Validators.required)
  })

  constructor(private bs:BatchService) { }

  ngOnInit(): void {
  }

  onSubmit(){
    const val:Batch = this.batchForm.value;
    if(this.batchForm.valid){
      this.bs.addBatch(val).subscribe();
    }
  }

}
