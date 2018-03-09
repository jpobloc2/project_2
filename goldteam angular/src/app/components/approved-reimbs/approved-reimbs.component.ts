import { Component, OnInit } from '@angular/core';
import { ReimburseService } from '../../services/reimburse.service';
import { Reimbursement } from '../../beans/reimbursement';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-approved-reimbs',
  templateUrl: './approved-reimbs.component.html',
  styleUrls: ['./approved-reimbs.component.css']
})
export class ApprovedReimbsComponent implements OnInit {
  reimbs: any = [];
  ck;



  constructor(private reimbService: ReimburseService, private client: HttpClient, private cookie: CookieService) { }

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

}
