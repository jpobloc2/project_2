import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { ReimburseService } from '../../services/reimburse.service';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-pending-reimbs',
  templateUrl: './pending-reimbs.component.html',
  styleUrls: ['./pending-reimbs.component.css']
})
export class PendingReimbsComponent implements OnInit {
  reimbs: any = [];

  ck;



  constructor(private reimbService: ReimburseService, private client: HttpClient, private router: Router, private cookie: CookieService) { }

  ngOnInit() {
    this.ck = this.cookie.getObject('user');
    console.log(this.ck.roleId);
    if (this.ck.roleId === 0  ) {
      this.client.get(`http://localhost:8080/reimb/${this.ck.uId}`)
        .subscribe(
          (succ: Array<Reimbursement>) => {
            this.reimbs = succ;
            console.log(succ);
            return this.reimbs;
          },
          err => {
            alert('failed to retrieve reimbursements');
          }

        );
    } else {
      this.client.get('http://localhost:8080/reimb/all')
        .subscribe(
          (succ: Array<Reimbursement>) => {
            this.reimbs = succ;
            console.log(succ);
            return this.reimbs;
          },
          err => {
            alert('failed to retrieve reimbursements');
          }

        );

    }
  }

  updateStatus(reimb: Reimbursement, statusId: number) {
    console.log(reimb.r_id);
    this.client.put(`http://localhost:8080/Reimbursement-System/reimbursement/${reimb.r_id}`, statusId, { withCredentials: true })
      .subscribe(
        succ => {
          if (statusId === 1) {
            reimb.status = 1;
            alert('Reimbursement approved');
            this.router.navigateByUrl('reimbs');
          }
          if (statusId === 2) {
            reimb.status = 2;
            alert('Reimbursement denied');
            this.router.navigateByUrl('reimbs');
          }
        },
        err => {
          alert('failed to update status');
        }
      );

  }


}
