import { Injectable } from '@angular/core';
import { Reimbursement } from '../beans/reimbursement';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { CookieService } from 'angular2-cookie/services/cookies.service';
@Injectable()
export class ReimburseService {

  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});

  reimbs: any = [];

  updateReimb = {
    itemId: 0,
    resolution: '',
    userId: 0

  };
  ck;

  constructor(private client: HttpClient, private router: Router, private cookie: CookieService) { }

  getReimbs(): any {
    this.header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
    console.log('reimb service called');
    this.client.get('http://localhost:8080/reimb/', {headers: this.header})
    .subscribe(
      succ => {
        console.log('result of the service: ');
        console.log(succ);
        this.reimbs = succ;
      },
      err => {
        alert('failed to retrieve reimbursements');
      }

    );
}
  submitReimb(reimbursement: any) {
    console.log('submitting reimbursement from service, which is ');
    console.log(reimbursement);
    this.header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
    this.client.post('http://localhost:8080/reimb/submit', reimbursement, {headers: this.header})
    .subscribe(
      (succ) => {
        alert('submit successful');
        console.log(succ);
        this.router.navigateByUrl('reimbs');
      },
      (err) => {
        alert('failed to submit reimbursement');
      }


    );
  }

  /* updateReimbursement(reimbursement: any) {
    console.log('updating reimbursement from service');
    this.header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
    this.client.put(`http://localhost:8080/reimb`, this.updateReimb, {headers: this.header})
    .subscribe(
      succ => {
        alert('update successful');
      },
      err => {
        alert('failed to update status');
      }
    );
  } */

}
