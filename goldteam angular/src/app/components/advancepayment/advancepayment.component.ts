import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-advancepayment',
  templateUrl: './advancepayment.component.html',
  styleUrls: ['./advancepayment.component.css']
})
export class AdvancepaymentComponent implements OnInit {


  private newPayment = {

    amount: 0,
    comment: ''

  };

  constructor() { }

  ngOnInit() {
  }

  submitPayment() {
    console.log(this.newPayment);
  }

}
