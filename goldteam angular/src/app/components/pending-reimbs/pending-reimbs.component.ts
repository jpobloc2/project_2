import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { ReimburseService } from '../../services/reimburse.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-pending-reimbs',
  templateUrl: './pending-reimbs.component.html',
  styleUrls: ['./pending-reimbs.component.css']
})
export class PendingReimbsComponent implements OnInit {
  header = new HttpHeaders({xtoken: `${localStorage.getItem('token')}`});
  reimbs: any = [];

  string = '';
  ck;

  updateReimb = {
    itemId: 0,
    resolution: '',
    userId: 0

  };



  constructor(private reimbService: ReimburseService, private client: HttpClient, private router: Router, private cookie: CookieService) { }
  ngOnInit() {
    this.ck = this.cookie.getObject('user');
    this.reimbs = this.reimbService.reimbs;

    }

  updateStatus(reimbId: number, reimbStatus: string) {
    this.updateReimb.itemId = reimbId;
    this.updateReimb.resolution = reimbStatus;
    this.updateReimb.userId = this.ck.uId;
    console.log(this.updateReimb);
    this.client.put(`http://localhost:8080/reimb`, this.updateReimb, {headers: this.header})
      .subscribe(
        succ => {
          if (reimbStatus === 'Accepted') {
            this.string = 'Reimbursement accepted!';
            this.ngOnInit();
          }
          if (reimbStatus === 'Declined') {
            this.string = 'Reimbursement denied!';
            this.ngOnInit();
          }
        },
        err => {
          alert('failed to update status');
        }
      );

  }


}
