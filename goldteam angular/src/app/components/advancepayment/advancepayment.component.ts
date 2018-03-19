import { Component, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';


import { Router } from '@angular/router';


@Component({
  selector: 'app-advancepayment',
  templateUrl: './advancepayment.component.html',
  styleUrls: ['./advancepayment.component.css']
})
export class AdvancepaymentComponent implements OnInit {

  header = new HttpHeaders({ xtoken: `${localStorage.getItem('token')}` });
  payments: any = [];
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
  failTableAlert = false;
  failSubmitAlert = false;
  sucSubmitAlert = false;
  updateAlert = false;

  constructor(private client: HttpClient, private cookie: CookieService, private router: Router) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
    console.log(this.ck.roleId);
    this.client.get(`http://localhost:8080/advpay/`, { headers: this.header })
      .subscribe(
        succ => {
          this.payments = succ;
          return this.payments;
        }, err => {
          this.failTableAlert = true;
        }
      );
  }

  submitPayment() {
    this.newPayment.author.userId = this.ck.uId;
    console.log(this.newPayment);
    this.client.post('http://localhost:8080/advpay/submit', this.newPayment, { headers: this.header })
      .subscribe(
        (succ: any) => {
          this.sucSubmitAlert = true;
          this.ngOnInit();
        },
        err => {
          this.failSubmitAlert = true;
        }
      );
  }

  updateStatus(payId: number, payStatus: string) {
    this.updatePayment.itemId = payId;
    this.updatePayment.resolution = payStatus;
    this.updatePayment.userId = this.ck.uId;
    console.log(this.updatePayment);
    this.client.put(`http://localhost:8080/advpay`, this.updatePayment, { headers: this.header })
      .subscribe(
        succ => {
          if (payStatus === 'Accepted') {
            this.updateAlert = true;
            this.ngOnInit();
          }
          if (payStatus === 'Declined') {
            this.updateAlert = true;
            this.ngOnInit();
          }
        },
        err => {
          alert('failed to update status');
        }
      );
  }

}
