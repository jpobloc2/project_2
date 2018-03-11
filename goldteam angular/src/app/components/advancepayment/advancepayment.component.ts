import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';


import { Router } from '@angular/router';


@Component({
  selector: 'app-advancepayment',
  templateUrl: './advancepayment.component.html',
  styleUrls: ['./advancepayment.component.css']
})
export class AdvancepaymentComponent implements OnInit {


  payments: any = [];

  string = '';

  // private newPayment = {

  //   amount: 0,
  //   comment: '',
  //   authorId: 0

  // };

  private newPayment = {

    amount: 0,


    advComment: '',
    author: {
      userId: 0
    },
    status: {
      status: 'Pending'
    }

  };
  private ck;



  updatePayment = {
    itemId: 0,
    resolution: '',
    userId: 0

  };
  private ck;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }


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
    this.newPayment.author.userId = this.ck.uId;
    console.log(this.newPayment);
    this.client.post('http/localhost:8080/advpay/submit', this.newPayment)
    .subscribe(
      succ => {
        alert('advance payment submitted');
        console.log(succ);
      },
      err => {
        alert('advance payment failed');
      }
    );
  }



  updateStatus(payId: number, payStatus: string) {
    this.updatePayment.itemId = payId;
    this.updatePayment.resolution = payStatus;
    this.updatePayment.userId = this.ck.uId;
    console.log(this.updatePayment);
    this.client.put(`http://localhost:8080/advpay`, this.updatePayment)
    .subscribe(
      succ => {
        if (payStatus === 'Accepted') {
          this.string = 'Advanced payment has been approved';
          this.ngOnInit();
        }
        if (payStatus === 'Declined') {
          this.string = 'Advanced payment has been denied';
          this.ngOnInit();
        }
      },
      err => {
        alert('failed to update status');
      }
    );
  }

}
