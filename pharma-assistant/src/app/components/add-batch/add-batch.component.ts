import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, FormBuilder } from '@angular/forms';
import { Batch } from 'src/app/models/batch';
import { BatchService } from 'src/app/services/batch.service';

@Component({
  selector: 'app-add-batch',
  templateUrl: './add-batch.component.html',
  styleUrls: ['./add-batch.component.css']
})
export class AddBatchComponent implements OnInit {

  content:Batch[] = []
  constructor(private bs:BatchService,private fb:FormBuilder) { }

  batchForm = this.fb.group({
    batchCode : ['',Validators.compose([Validators.pattern(/^BTC-[a-zA-Z0-9]*$/),Validators.required])],
    weight : ['',Validators.compose([Validators.min(100),Validators.required])],
    price : ['',Validators.required],
    refrigeration : ['',Validators.required],
    medicine : ['',Validators.required]
  })

  ngOnInit(): void {
  }

  onSubmit(){
    /*this.bs.getBatch().subscribe(
      data => {
        this.content = data;
      },
      err => {
        //this.content = JSON.parse(err.error).message;
      }
    );*/
    const val:Batch = this.batchForm.value;
    //console.log(this.content);
    console.log(this.batchForm.valid);
    if(this.batchForm.valid){
      this.bs.addBatch(val).subscribe(()=>{},
        err => {
          //console.log(JSON.parse(err.error).message);
        });
    }
  }

}