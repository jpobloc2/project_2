import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-advancepayment',
  templateUrl: './advancepayment.component.html',
  styleUrls: ['./advancepayment.component.css']
})
export class AdvancepaymentComponent implements OnInit {


  payments: any = [];

  private newPayment = {

    amount: 0,
    comment: '',
    authorId: 0

  };
  private ck;

  constructor(private client: HttpClient, private cookie: CookieService) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
    console.log(this.ck.roleId);
    if (this.ck.roleId === 0) {
    this.client.get(`http://localhost:8080/advpay/${this.ck.uId}`)
    .subscribe(
      succ => {
        this.payments = succ;
        console.log(this.payments);
        return this.payments;
      }, err => {
        alert('failed to retrieve payments');
      }
    );


    } else {
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
  }
  submitPayment() {
    console.log(this.newPayment);
  }

}
