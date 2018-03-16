import { Injectable } from '@angular/core';
import { Reimbursement } from '../beans/reimbursement';
import { HttpClient, HttpHeaders } from '@angular/common/http';
@Injectable()
export class ReimburseService {

  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});

  reimbs: any = [];


  constructor(private client: HttpClient) { }

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
// getPending(): any {
//   this.client.get('http://localhost:8080/Reimbursement-System/reimbursement/pending', { withCredentials: true })
//   .subscribe(
//     (succ: Array<Reimbursement>) => {
//       this.reimbs = succ;
//       console.log(succ);
//       return this.reimbs;
//     },
//     err => {
//       alert('failed to retrieve pending reimbursements');
//     }

//   );
// }

// getApproved(): any {
//   this.client.get('http://localhost:8080/Reimbursement-System/reimbursement/approved', { withCredentials: true })
//   .subscribe(
//     (succ: Array<Reimbursement>) => {
//       this.reimbs = succ;
//       console.log(succ);
//       return this.reimbs;
//     },
//     err => {
//       alert('failed to retrieve approved reimbursements');
//     }

//   );
// }

// getDenied(): any {
//   this.client.get('http://localhost:8080/Reimbursement-System/reimbursement/denied', { withCredentials: true })
//   .subscribe(
//     (succ: Array<Reimbursement>) => {
//       this.reimbs = succ;
//       console.log(succ);
//       return this.reimbs;
//     },
//     err => {
//       alert('failed to retrieve denied reimbursements');
//     }

//   );
// }
}
