import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class AdvpaymentService {

  constructor(private client: HttpClient) { }

  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});

  payments: any = [];

  getPayments(): any {
    this.header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
    this.client.get(`http://localhost:8080/advpay/`, { headers: this.header })
      .subscribe(
        succ => {
          this.payments = succ;
          console.log(this.payments);
          return this.payments;
        }, err => {
          alert('failed to retrieve payments');
        }
      );
  }

}
