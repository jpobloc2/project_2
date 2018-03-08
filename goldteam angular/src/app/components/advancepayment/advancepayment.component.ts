import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-advancepayment',
  templateUrl: './advancepayment.component.html',
  styleUrls: ['./advancepayment.component.css']
})
export class AdvancepaymentComponent implements OnInit {


  payments: any = [];

  private newPayment = {

    amount: 0,
    comment: ''

  };

  constructor(private client: HttpClient) { }

  ngOnInit() {
  }

  submitPayment() {
    console.log(this.newPayment);
  }

}
