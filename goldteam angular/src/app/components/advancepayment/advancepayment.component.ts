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
    this.client.get('http://localhost:8080/advpay/all')
    .subscribe(
      succ => {
        this.payments = succ;
        console.log(succ);
        return this.payments;

      }, err => {
        alert('failed to retrieve payments');
      }

    );
  }

  submitPayment() {
    console.log(this.newPayment);
  }

}
