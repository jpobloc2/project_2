import { Component, OnInit } from '@angular/core';
import { Reimbursement } from '../../beans/reimbursement';
import { ReimburseService } from '../../services/reimburse.service';
import { HttpClient } from '@angular/common/http';
import { CookieService } from 'angular2-cookie/services/cookies.service';

@Component({
  selector: 'app-all-reimbs',
  templateUrl: './all-reimbs.component.html',
  styleUrls: ['./all-reimbs.component.css']
})
export class AllReimbsComponent implements OnInit {

  // reimbs: Array<Reimbursement> = [];
  // newReimb = new Reimbursement();

  reimbs: any = [];
  private ck;

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
