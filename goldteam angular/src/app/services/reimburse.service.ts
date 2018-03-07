import { Injectable } from '@angular/core';
import { Reimbursement } from '../beans/reimbursement';
import { HttpClient } from '@angular/common/http';
@Injectable()
export class ReimburseService {

  // reimbs: Array<Reimbursement> = [
  //   new Reimbursement(1, 450, null, null, 'My pending description', 1, 2, 1, 0),
  //   new Reimbursement(2, 50, null, null, 'My 2nd pending ', 3, 2, 1, 1),
  //   new Reimbursement(3, 1000, null, null, 'My 3rd pending', 4, 2, 1, 3),
  //   new Reimbursement(4, 75, null, null, 'My approved ticket', 7, 2, 2, 2),
  //   new Reimbursement(5, 1200, null, null, 'My declined ticket', 4, 2, 3, 3),
  //   new Reimbursement(6, 75, null, null, 'My other approved ticket', 7, 2, 2, 2),
  //   new Reimbursement(7, 800, null, null, 'My other declined ticket', 4, 2, 3, 1),
  // ];

  reimbs: Array<Reimbursement> = [];


  constructor(private client: HttpClient) { }

  getReimbs(): any {
    this.client.get('http://localhost:8080/Reimbursement-System/reimbursement/all', { withCredentials: true })
    .subscribe(
      (succ: Array<Reimbursement>) => {
        return this.reimbs = succ;
       // console.log(succ);
      },
      err => {
        alert('failed to retrieve reimbursements');
      }

    );
}
getPending(): any {
  this.client.get('http://localhost:8080/Reimbursement-System/reimbursement/pending', { withCredentials: true })
  .subscribe(
    (succ: Array<Reimbursement>) => {
      this.reimbs = succ;
      console.log(succ);
      return this.reimbs;
    },
    err => {
      alert('failed to retrieve pending reimbursements');
    }

  );
}

getApproved(): any {
  this.client.get('http://localhost:8080/Reimbursement-System/reimbursement/approved', { withCredentials: true })
  .subscribe(
    (succ: Array<Reimbursement>) => {
      this.reimbs = succ;
      console.log(succ);
      return this.reimbs;
    },
    err => {
      alert('failed to retrieve approved reimbursements');
    }

  );
}

getDenied(): any {
  this.client.get('http://localhost:8080/Reimbursement-System/reimbursement/denied', { withCredentials: true })
  .subscribe(
    (succ: Array<Reimbursement>) => {
      this.reimbs = succ;
      console.log(succ);
      return this.reimbs;
    },
    err => {
      alert('failed to retrieve denied reimbursements');
    }

  );
}
}
